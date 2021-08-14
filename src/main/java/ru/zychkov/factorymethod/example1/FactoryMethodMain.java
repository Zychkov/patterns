package main.java.ru.zychkov.factorymethod.example1;

public class FactoryMethodMain {

    public static void main(String[] args) {
        Person person = Person.create();
    }
}

class Person {
    private Person() {}

    public static Person create() {
        return new Person();
    }
}