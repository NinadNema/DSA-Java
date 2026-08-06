package oop.polymorphism;

public class MethodOverloading {
    int sum(int a, int b){
        return a + b;
    }

    int sum(int a, int b, int c){
        return a + b + c;
    }

    double sum(double a, double b){
        return a +b;
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();

        System.out.println(obj.sum(2, 5));
        System.out.println(obj.sum(2, 5, 8));
        System.out.println(obj.sum(2.6, 5.3));
    }
}
