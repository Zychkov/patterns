package main.java.ru.zychkov.generative.singleton.example1;

public class SingletonMain {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {

    static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}