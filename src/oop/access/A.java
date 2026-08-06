package oop.access;

public class A {

    private int num;
    String name;          // default access

    public A(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    void display() {
        System.out.println("Number : " + num);
        System.out.println("Name   : " + name);
    }
}