package heap;

public class MinHeap extends Heap {

    public MinHeap() {
        super(true);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();

        heap.insert(30);
        heap.insert(10);
        heap.insert(50);
        heap.insert(5);
        heap.insert(20);

        System.out.print("Min Heap: ");
        heap.display();

        System.out.println("Minimum: " + heap.peek());

        System.out.println("Removing elements:");

        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }

        System.out.println();
    }
}