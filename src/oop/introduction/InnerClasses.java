package oop.introduction;

public class InnerClasses {

    static class Test {

        String name;

        Test(String name) {
            this.name = name;
        }

        void display() {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {

        Test obj1 = new Test("Ninad");
        Test obj2 = new Test("Rahul");

        obj1.display();
        obj2.display();
    }
}
