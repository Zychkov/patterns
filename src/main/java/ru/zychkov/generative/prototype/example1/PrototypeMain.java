package ru.zychkov.generative.prototype.example1;

public class PrototypeMain {

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.setStudent(new Student());

        try {
            Student student = cache.getStudent();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class Student implements Cloneable {

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}

class Cache {

    private Student student;

    public Student getStudent() throws CloneNotSupportedException {
        return student.clone();
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}