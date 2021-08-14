package main.java.ru.zychkov.chainofresponsibility.example1;

public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();

        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(new DBMessagePrinter());

        messagePrinter.print("Hello");
    }
}

abstract class MessagePrinter {

    MessagePrinter nextMessagePrinter;

    void setNextMessagePrinter(MessagePrinter messagePrinter) {
        nextMessagePrinter = messagePrinter;
    }

    void print(String message) {
        printMessage(message);

        if (nextMessagePrinter != null) {
            nextMessagePrinter.print(message);
        }
    }

    abstract void printMessage(String message);
}

class ConsoleMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);
    }
}

class FileMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);
    }
}

class DBMessagePrinter extends MessagePrinter {

    @Override
    void printMessage(String message) {
        System.out.println("print to DB: " + message);
    }
}