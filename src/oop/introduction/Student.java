package oop.introduction;

public class Student {

    int rollNo;
    String name;
    float marks;

    Student() {
        this.rollNo = 0;
        this.name = "Unknown";
        this.marks = 0.0f;
    }

    Student(int rollNo, String name, float marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Roll No : " + rollNo);
        System.out.println("Name    : " + name);
        System.out.println("Marks   : " + marks);
    }
}