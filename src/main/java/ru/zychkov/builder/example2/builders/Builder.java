package main.java.ru.zychkov.builder.example2.builders;

import main.java.ru.zychkov.builder.example2.cars.CarType;
import main.java.ru.zychkov.builder.example2.components.Engine;
import main.java.ru.zychkov.builder.example2.components.GPSNavigator;
import main.java.ru.zychkov.builder.example2.components.Transmission;
import main.java.ru.zychkov.builder.example2.components.TripComputer;

public interface Builder {

    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
