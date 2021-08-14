package main.java.ru.zychkov.structural.flyweight.example1;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightMain {

    public static void main(String[] args) {
        FlyWeightGarage garage = new FlyWeightGarage();
        Mercedes green = garage.getMers("green");
        Mercedes green2 = garage.getMers("green");
        System.out.println(green.color);
        System.out.println(green == green2);
    }
}

class Mercedes {

    String color;
}

class FlyWeightGarage {

    Map<String, Mercedes> map = new HashMap<>();

    Mercedes getMers(String color) {
        Mercedes mercedes = map.get(color);

        if (mercedes == null) {
            mercedes = new Mercedes();
            mercedes.color = color;
            map.put(color, mercedes);
        }

        return mercedes;
    }
}