package main.java.ru.zychkov.builder.example2.builders;

import main.java.ru.zychkov.builder.example2.cars.CarType;
import main.java.ru.zychkov.builder.example2.cars.Manual;
import main.java.ru.zychkov.builder.example2.components.Engine;
import main.java.ru.zychkov.builder.example2.components.GPSNavigator;
import main.java.ru.zychkov.builder.example2.components.Transmission;
import main.java.ru.zychkov.builder.example2.components.TripComputer;

public class CarManualBuilder implements Builder {

    private CarType type;
    private int seats;
    private Engine engine;
    private Transmission transmission;
    private TripComputer tripComputer;
    private GPSNavigator gpsNavigator;

    @Override
    public void setCarType(CarType type) {
        this.type = type;
    }

    @Override
    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public void setTripComputer(TripComputer tripComputer) {
        this.tripComputer = tripComputer;
    }

    @Override
    public void setGPSNavigator(GPSNavigator gpsNavigator) {
        this.gpsNavigator = gpsNavigator;
    }

    public Manual getResult() {
        return new Manual(type, seats, engine, transmission, tripComputer, gpsNavigator);
    }
}
