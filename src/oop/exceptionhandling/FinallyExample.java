package oop.exceptionhandling;

public class FinallyExample {

    public static void main(String[] args) {

        try {

            int ans = 10 / 2;

            System.out.println(ans);

        } finally {

            System.out.println("Finally Block Always Executes");
        }
    }
}