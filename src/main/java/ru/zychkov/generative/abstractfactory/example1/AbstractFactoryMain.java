package ru.zychkov.generative.abstractfactory.example1;

public class AbstractFactoryMain {

    public static void main(String[] args) {
        Factory carFactory = new AbstractFactory().createFactory("Car");
        Factory tankFactory = new AbstractFactory().createFactory("Tank");

        Car toyota = carFactory.createCar("Toyota");
        Car audi = carFactory.createCar("Audi");
        toyota.drive();
        audi.drive();

        Tank t50 = tankFactory.createTank("T50");
        Tank t52 = tankFactory.createTank("T52");
        t50.drive();
        t52.drive();
    }
}

interface Car {

    void drive();
}

class Toyota implements Car {

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class Audi implements Car {

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}

class CarFactory implements Factory {

    @Override
    public Car createCar(String typeOfCar) {
        switch (typeOfCar) {
            case "Toyota":
                return new Toyota();
            case "Audi":
                return new Audi();
            default:
                return null;
        }
    }

    @Override
    public Tank createTank(String typeOfTank) {
        return null;
    }
}

interface Tank {

    void drive();
}

class T50 implements Tank {

    @Override
    public void drive() {
        System.out.println("drive T50");
    }
}

class T52 implements Tank {

    @Override
    public void drive() {
        System.out.println("drive T52");
    }
}

class TankFactory implements Factory {

    @Override
    public Car createCar(String typeOfCar) {
        return null;
    }

    @Override
    public Tank createTank(String typeOfTank) {
        switch (typeOfTank) {
            case "T50":
                return new T50();
            case "T52":
                return new T52();
            default:
                return null;
        }
    }
}

interface Factory {
    Car createCar(String typeOfCar);
    Tank createTank(String typeOfTank);
}

class AbstractFactory {

    Factory createFactory(String typeOfFactory) {
        switch (typeOfFactory) {
            case "Car":
                return new CarFactory();
            case "Tank":
                return new TankFactory();
            default:
                return null;
        }
    }
}

