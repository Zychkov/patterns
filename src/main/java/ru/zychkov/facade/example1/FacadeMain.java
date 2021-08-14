package main.java.ru.zychkov.facade.example1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FacadeMain {

    public static void main(String[] args) throws IOException {
/*
        BufferedReader reader = new BufferedReader(new FileReader("temp.txt"));
        StringBuilder stringBuilder = new StringBuilder();

        int j;

        while ((j = reader.read()) != -1) {
            stringBuilder.append((char) j);
        }
*/
        FileReadFacade facade = new FileReadFacade();
        System.out.println(facade.readFile("temp.txt"));
    }
}

class FileReadFacade {

    String readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder stringBuilder = new StringBuilder();

        int j;

        while ((j = reader.read()) != -1) {
            stringBuilder.append((char) j);
        }

       return stringBuilder.toString();
    }
}
