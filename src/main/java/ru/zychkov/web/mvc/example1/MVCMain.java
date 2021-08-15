package ru.zychkov.web.mvc.example1;

public class MVCMain {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}

class Student {
    String name = "Max";
    int age = 20;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface ModelLayer {
    Student getStudent();
}

class DBLayer implements ModelLayer {

    @Override
    public Student getStudent() {
        return new Student();
    }
}

interface View {
    void showStudent(Student student);
}

class ConsoleView implements View {

    @Override
    public void showStudent(Student student) {
        System.out.println("Student name: " + student.name + ", age: " + student.age);
    }
}

class Controller {
    ModelLayer modelLayer = new DBLayer();
    View view = new ConsoleView();


    void execute() {
        Student student = modelLayer.getStudent();
        view.showStudent(student);
    }
}

