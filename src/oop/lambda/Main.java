package oop.lambda;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        Operation add = (a, b) -> a + b;

        Operation subtract = (a, b) -> a - b;

        Operation multiply = (a, b) -> a * b;

        Operation divide = (a, b) -> a / b;

        System.out.println(calculator.calculate(add,10,5));

        System.out.println(calculator.calculate(subtract,10,5));

        System.out.println(calculator.calculate(multiply,10,5));

        System.out.println(calculator.calculate(divide,10,5));
    }
}