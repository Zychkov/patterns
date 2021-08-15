package ru.zychkov.behavioral.nullobject.example1;

import java.io.File;

public class NullObjectMain {

    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }

    static Animal getAnimal() {
        try {
            if(new File("nosuchfile.txt").exists()) {
                //read file and create Lion

                return new Lion();
            }
        } finally {
            return new NoAnimal();
        }
    }
}

interface Animal {
    void eat();
}

class Lion implements Animal {

    @Override
    public void eat() {
        System.out.println("Lion eats");
    }
}

class NoAnimal implements Animal {

    @Override
    public void eat() {

    }
}

