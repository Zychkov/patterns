package ru.zychkov.structural.adapter.example1;

public class AdapterMain {

    public static void main(String[] args) {
        CarWash carWash = new CarWash();
        carWash.washCar(new Audi());
        carWash.washCar(new TrackWrap(new MyTrack()));
    }
}

class TrackWrap implements Car{
    Track track;

    public TrackWrap(Track track) {
        this.track = track;
    }

    @Override
    public void wash() {
        track.clean();
    }
}

interface Track {
    void clean();
}

class MyTrack implements Track {

    @Override
    public void clean() {
        System.out.println("Track is clean");
    }
}

interface Car {

    void wash();
}

class Audi implements Car {

    @Override
    public void wash() {
        System.out.println("wash car audi");
    }

}

class CarWash {

    public void washCar(Car car) {
        car.wash();
    }
}