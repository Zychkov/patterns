package main.java.ru.zychkov.bridge.example2;

import main.java.ru.zychkov.bridge.example2.devices.Device;
import main.java.ru.zychkov.bridge.example2.devices.Radio;
import main.java.ru.zychkov.bridge.example2.devices.Tv;
import main.java.ru.zychkov.bridge.example2.remotes.AdvancedRemote;
import main.java.ru.zychkov.bridge.example2.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
