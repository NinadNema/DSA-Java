package oop.exceptionhandling;

public class Main {

    static void validate(int marks) throws MyException{

        if(marks > 100){

            throw new MyException("Marks cannot exceed 100");

        }

        System.out.println("Valid Marks");
    }

    public static void main(String[] args) {

        try{

            validate(120);

        }catch (MyException e){

            System.out.println(e.getMessage());

        }
    }
}