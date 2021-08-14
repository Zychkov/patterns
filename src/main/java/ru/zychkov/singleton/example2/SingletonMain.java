package main.java.ru.zychkov.singleton.example2;

public class SingletonMain {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {

    private static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }

        return uniqueInstance;
    }
}