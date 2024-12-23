package reflection;

/**
 * класс реализующий интерфейс SomeOtherInterface
 */
public class SODoer implements SomeOtherInterface{

    /**
     * метод переопределяющий doSomething и выводящий строку "С" на консоль
     */
    @Override
    public void doSomething()
    {
        System.out.println("C");
    }
}
