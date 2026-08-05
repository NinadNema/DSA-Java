package oop.staticexample;

public class StaticMethod {

    static void greet() {
        System.out.println("Hello from Static Method");
    }

    void display() {
        System.out.println("Non-static Method");
    }

    public static void main(String[] args) {

        greet();

        StaticMethod obj = new StaticMethod();
        obj.display();
    }
}