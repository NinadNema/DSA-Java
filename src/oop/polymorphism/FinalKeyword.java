package oop.polymorphism;

class Parent{
    final void display(){
        System.out.println("Final Method");
    }
}

public class FinalKeyword extends Parent{
    public static void main(String[] args) {
        FinalKeyword obj = new FinalKeyword();

        obj.display();

//        Not Allowed
//        void display(){}
    }
}
