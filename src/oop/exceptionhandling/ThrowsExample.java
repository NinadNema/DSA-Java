package oop.exceptionhandling;

public class ThrowsExample {

    static void divide(int a,int b) throws ArithmeticException{

        System.out.println(a / b);
    }

    public static void main(String[] args) {

        try{

            divide(10,0);

        }catch (ArithmeticException e){

            System.out.println(e.getMessage());

        }
    }
}