package oop.generics;

import java.util.Arrays;

public class CustomArrayList {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList() {
        data = new int[DEFAULT_SIZE];
    }

    public void add(int value) {

        if (isFull()) {
            resize();
        }

        data[size++] = value;
    }

    public int remove() {
        return data[--size];
    }

    public int get(int index) {
        return data[index];
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public int size() {
        return size;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}