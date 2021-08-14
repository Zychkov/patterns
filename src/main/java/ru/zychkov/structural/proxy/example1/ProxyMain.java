package main.java.ru.zychkov.structural.proxy.example1;

public class ProxyMain {

    public static void main(String[] args) {
        Car car = new CarProxy();
        car.drive();
    }
}

interface Car {
    void drive();
}

class CarProxy implements Car {

    Car car = new Reno();

    @Override
    public void drive() {
        System.out.println("proxy code");
        car.drive();
    }
}

class Reno implements Car {

    @Override
    public void drive() {
        System.out.println("Drive Reno");
    }
}