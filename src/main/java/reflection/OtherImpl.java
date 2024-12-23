package reflection;

/**
 * класс реализующий интерфейс SomeInterface
 */
public class OtherImpl implements SomeInterface{

    /**
     * метод переопределяющий doSomething и выводящий строку "B" на консоль
     */
    @Override
    public void doSomething()
    {
        System.out.println("B");
    }
}
