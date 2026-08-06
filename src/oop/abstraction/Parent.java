package oop.abstraction;

public abstract class Parent {

    Parent() {
        System.out.println("Parent Constructor");
    }

    abstract void career();

    abstract void partner();

    void greeting() {
        System.out.println("Welcome!");
    }
}