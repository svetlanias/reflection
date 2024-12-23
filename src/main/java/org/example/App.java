package org.example;

import java.io.IOException;

public class App 
{
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        SomeBean ac = (new Injector<SomeBean>("src/main/resources/injection1.properties").inject(new SomeBean()));
        ac.function();
        SomeBean bc = (new Injector<SomeBean>("src/main/resources/injection2.properties").inject(new SomeBean()));
        bc.function();
    }
}
