package ru.zychkov.behavioral.command.example1;

import java.util.ArrayList;
import java.util.List;

public class CommandMain {

    public static void main(String[] args) {
/*
        wrong!

        Command command = new MouseClick();
        command.execute();*/

        Receiver receiver = new Receiver();
        receiver.addCommands(new MouseClick());
        receiver.addCommands(new MousePress());
        receiver.runCommand();
    }
}

interface Command {

    void execute();

    void revert();
}

class MouseClick implements Command {

    @Override
    public void execute() {
        System.out.println("click command");
    }

    @Override
    public void revert() {
        System.out.println("revert");
    }
}

class MousePress implements Command {

    @Override
    public void execute() {
        System.out.println("press command");
    }

    @Override
    public void revert() {
        System.out.println("revert");
    }
}

class Receiver {
    List<Command> commands = new ArrayList<>();

    void addCommands(Command command) {
        commands.add(command);
    }

    void runCommand() {

        try {
            for (Command command : commands) {
                command.execute();
            }
        } catch (Exception e) {
            for (Command command : commands) {
                command.revert();
            }
        }
    }
}