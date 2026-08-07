package oop.cloning;

import java.util.Arrays;

public class DeepCopy implements Cloneable{

    int[] arr;

    DeepCopy(){

        arr = new int[]{1,2,3};

    }

    @Override
    protected DeepCopy clone() throws CloneNotSupportedException {

        DeepCopy copy = (DeepCopy) super.clone();

        copy.arr = arr.clone();

        return copy;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        DeepCopy d1 = new DeepCopy();

        DeepCopy d2 = d1.clone();

        d2.arr[0] = 100;

        System.out.println(Arrays.toString(d1.arr));

        System.out.println(Arrays.toString(d2.arr));
    }
}