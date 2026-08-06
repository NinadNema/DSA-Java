package oop.polymorphism;

class ParentStatic {

    static void greet() {
        System.out.println("Parent Greeting");
    }
}

class ChildStatic extends ParentStatic {

    static void greet() {
        System.out.println("Child Greeting");
    }
}

public class StaticMethods {

    public static void main(String[] args) {

        ParentStatic.greet();
        ChildStatic.greet();

        ParentStatic obj = new ChildStatic();

//      Instead of Using object use Class for calling static method
//        obj.greet();
        ParentStatic.greet();
    }
}