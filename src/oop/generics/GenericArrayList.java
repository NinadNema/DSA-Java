package oop.generics;

import java.util.Arrays;

public class GenericArrayList<T> {

    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public GenericArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T value) {

        if (size == data.length) {
            resize();
        }

        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size));
    }
}