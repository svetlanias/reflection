package org.example;

import reflection.SomeInterface;
import reflection.SomeOtherInterface;

/**
 * класс, содержащий две аннотации
 */
public class SomeBean {
    @AutoInjectable
    private SomeInterface field1;

    @AutoInjectable
    private SomeOtherInterface field2;

    //public SomeBean(){}

    /**
     * метод, вызывающий для полей с аннотациями методы doSomething
     */
    public void function(){
        field1.doSomething();
        field2.doSomething();
    }
}
