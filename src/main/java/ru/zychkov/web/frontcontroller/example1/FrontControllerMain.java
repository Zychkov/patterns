package ru.zychkov.web.frontcontroller.example1;

import java.util.Scanner;

public class FrontControllerMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            new Thread() {
                @Override
                public void run() {
                    new DispatcherServlet().process(scanner.nextLine());
                }
            }.start();
        }
    }
}

class DispatcherServlet {

    public void process(String url) {
        switch (url) {
            case "home" : new HomeController().show(); break;
            case "user" : new UserController().show(); break;
            default: new DefaultController().show();
        }
    }
}

class HomeController {
    void show() {
        System.out.println("this is home page");
    }
}

class UserController {
    void show() {
        System.out.println("this is user page");
    }
}

class DefaultController {
    void show() {
        System.out.println("error");
    }
}


