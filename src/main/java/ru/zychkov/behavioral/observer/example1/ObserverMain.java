package main.java.ru.zychkov.behavioral.observer.example1;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {

    public static void main(String[] args) {
        Observer observer = new Observer("one");
        Observer observer2 = new Observer("two");

        observer.setState("new state");
    }
}

interface Observable {

    void update();
}

class Observer implements Observable {

    private static List<Observer> observers = new ArrayList<>();
    private String name;
    private String state;


    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public void update() {
        System.out.println(name + " change status:" + state);
    }
}

