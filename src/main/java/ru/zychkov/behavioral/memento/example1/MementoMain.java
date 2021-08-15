package ru.zychkov.behavioral.memento.example1;

public class MementoMain {

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("one");

        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(originator.createMemento());

        originator.setState("two");
        System.out.println(originator.getState());

        originator.getDataFromMemento(careTaker.getMemento());
        System.out.println(originator.getState());
    }
}

class CareTaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    Memento createMemento() {
        return new Memento(state);
    }

    void getDataFromMemento(Memento memento){
        this.state = memento.getState();
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}