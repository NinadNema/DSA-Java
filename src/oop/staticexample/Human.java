package oop.staticexample;

public class Human {

    String name;
    int age;
    static long population;

    Human(String name, int age) {
        this.name = name;
        this.age = age;
        population++;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}