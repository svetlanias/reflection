package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * класс реализующий механизм внедрения зависимостей в объект,
 * содержащий поля, помеченные аннотацией @AutoInjectable
 */
public class Injector<T>{
    /**
     * поле класса, хранящее ссылку на объект Properties
     */
    private final Properties props;

    /**
     * конструктор класса
     * @param pathToPropertiesFile путь к файлу свойств
     * @throws IOException, если происходит ошибка ввода-вывода при загрузке файла свойств
     */
    Injector(String pathToPropertiesFile) throws IOException {
        props = new Properties();
        props.load(new FileInputStream(new File(pathToPropertiesFile)));
    }

    /**
     * метод inject принимает объект, проверяет в немтналичие полей с аннотацией @AutoInjectable,
     * и инициализирует эти поля экземплярами классов, указанных в файле свойств
     * @param object объект какого-либо класса
     * @return объект с внедренными зависимостями
     */
    T inject(T object) throws IllegalAccessException, InstantiationException {

        Class dependency;
        Class objClass = object.getClass();

        for (Field field: objClass.getDeclaredFields()){
            if(field.isAnnotationPresent(AutoInjectable.class))
            {
                String interfaceName = field.getType().getCanonicalName();
                String implementationName = props.getProperty(interfaceName);

                if (implementationName != null) {

                    try {
                        dependency = Class.forName(implementationName);

                    } catch (ClassNotFoundException e) {
                        System.out.println("class not found");
                        continue;
                    }

                    field.setAccessible(true);
                    field.set(object, dependency.newInstance());
                }
            }
        }
        return object;
    }
}