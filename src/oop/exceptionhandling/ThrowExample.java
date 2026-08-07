package oop.exceptionhandling;

public class ThrowExample {

    static void checkAge(int age){

        if(age < 18){
            throw new ArithmeticException("Age must be at least 18.");
        }

        System.out.println("Eligible");
    }

    public static void main(String[] args) {

        checkAge(15);
    }
}