package oop.introduction;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student();

        System.out.println("Default Constructor");
        student1.display();

        System.out.println();

        Student student2 = new Student(101, "Ninad", 95.5f);

        System.out.println("Parameterized Constructor");
        student2.display();
    }
}