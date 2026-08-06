package oop.abstractclasses;

public abstract class Parent {

    Parent() {
        System.out.println("Parent Constructor Called");
    }

    abstract void career();

    abstract void partner();

    static void message() {
        System.out.println("Static methods are allowed in abstract classes.");
    }

    void greeting() {
        System.out.println("Welcome from Parent");
    }
}