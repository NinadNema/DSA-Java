package oop.introduction;

public class WrapperExample {

    public static void main(String[] args) {

        int a = 10;
        Integer b = Integer.valueOf(a);

        System.out.println("Primitive int : " + a);
        System.out.println("Wrapper Integer : " + b);

        Integer num = 50;
        int value = num;

        System.out.println("Auto Unboxing : " + value);
    }
}