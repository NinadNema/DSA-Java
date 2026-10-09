package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {

    protected int[] data;
    protected int size;
    private boolean minHeap;

    public Heap(boolean minHeap) {
        this.data = new int[10];
        this.size = 0;
        this.minHeap = minHeap;
    }

    public void insert(int value) {
        ensureCapacity();

        data[size] = value;
        int index = size;
        size++;

        while (index > 0) {
            int parent = (index - 1) / 2;

            if (!shouldSwap(data[index], data[parent])) {
                break;
            }

            swap(index, parent);
            index = parent;
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return data[0];
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int removed = data[0];
        data[0] = data[size - 1];
        size--;

        heapifyDown(0);

        return removed;
    }

    private void heapifyDown(int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int target = index;

            if (left < size &&
                    shouldSwap(data[left], data[target])) {
                target = left;
            }

            if (right < size &&
                    shouldSwap(data[right], data[target])) {
                target = right;
            }

            if (target == index) {
                break;
            }

            swap(index, target);
            index = target;
        }
    }

    private boolean shouldSwap(int child, int parent) {
        return minHeap ? child < parent : child > parent;
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void display() {
        System.out.println(
                Arrays.toString(Arrays.copyOf(data, size))
        );
    }

    public static void main(String[] args) {
        Heap heap = new Heap(true);

        heap.insert(40);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(20);

        System.out.print("Heap array: ");
        heap.display();

        System.out.println("Root: " + heap.peek());
        System.out.println("Removed: " + heap.remove());

        System.out.print("After removal: ");
        heap.display();
    }
}