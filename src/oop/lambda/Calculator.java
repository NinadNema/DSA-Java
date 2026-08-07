package oop.lambda;

public class Calculator {

    int calculate(Operation op, int a, int b) {
        return op.operation(a, b);
    }
}