package reflection;

/**
 * класс реализующий интерфейс SomeInterface
 */
public class SomeImpl implements SomeInterface{

    /**
     * метод переопределяющий doSomething и выводящий строку "А" на консоль
     */
    @Override
    public void doSomething()
    {
        System.out.println("A");
    }
}
