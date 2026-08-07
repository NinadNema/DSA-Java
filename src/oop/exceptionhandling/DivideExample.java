package oop.exceptionhandling;

public class DivideExample {

    static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        try {
            System.out.println(divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
            System.out.println(e.getMessage());
        }
    }
}