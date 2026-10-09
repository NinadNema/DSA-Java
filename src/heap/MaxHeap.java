package heap;

public class MaxHeap extends Heap {

    public MaxHeap() {
        super(false);
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();

        heap.insert(30);
        heap.insert(10);
        heap.insert(50);
        heap.insert(5);
        heap.insert(20);

        System.out.print("Max Heap: ");
        heap.display();

        System.out.println("Maximum: " + heap.peek());

        System.out.println("Removing elements:");

        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }

        System.out.println();
    }
}