package ru.zychkov.generative.builder.example2.builders;

import ru.zychkov.generative.builder.example2.cars.CarType;
import ru.zychkov.generative.builder.example2.components.Engine;
import ru.zychkov.generative.builder.example2.components.GPSNavigator;
import ru.zychkov.generative.builder.example2.components.Transmission;
import ru.zychkov.generative.builder.example2.components.TripComputer;

public interface Builder {

    void setCarType(CarType type);

    void setSeats(int seats);

    void setEngine(Engine engine);

    void setTransmission(Transmission transmission);

    void setTripComputer(TripComputer tripComputer);

    void setGPSNavigator(GPSNavigator gpsNavigator);
}
