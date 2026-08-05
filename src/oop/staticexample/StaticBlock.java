package oop.staticexample;

public class StaticBlock {

    static int a = 10;
    static int b;

    static {

        System.out.println("Static Block Executed");

        b = a * 5;
    }

    public static void main(String[] args) {

        System.out.println(a);
        System.out.println(b);
    }
}