package oop.access;

public class ObjectDemo {

    int num;

    ObjectDemo(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return num;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ObjectDemo)) {
            return false;
        }

        ObjectDemo other = (ObjectDemo) obj;

        return this.num == other.num;
    }

    @Override
    public String toString() {
        return "ObjectDemo{num=" + num + '}';
    }

    public static void main(String[] args) {

        ObjectDemo obj1 = new ObjectDemo(10);
        ObjectDemo obj2 = new ObjectDemo(10);
         ObjectDemo obj3 = new ObjectDemo(20);

        System.out.println(obj1.equals(obj2));

        System.out.println(obj1.equals(obj3));

        System.out.println(obj1.hashCode());

        System.out.println(obj1);

        System.out.println(obj1.getClass());

        System.out.println(obj1 instanceof ObjectDemo);
    }
}