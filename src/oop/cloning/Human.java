package oop.cloning;

import java.util.Arrays;

public class Human implements Cloneable{

    int age;
    String name;
    int[] marks;

    public Human(int age,String name){

        this.age = age;
        this.name = name;

        this.marks = new int[]{90,80,70};
    }

    @Override
    protected Human clone() throws CloneNotSupportedException {

        return (Human) super.clone();
    }

    @Override
    public String toString() {
        return name + " " + age + " " + Arrays.toString(marks);
    }
}