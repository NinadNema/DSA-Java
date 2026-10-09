package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        minPQ.offer(40);
        minPQ.offer(10);
        minPQ.offer(30);
        minPQ.offer(5);
        minPQ.offer(20);

        System.out.println("Min Priority Queue");
        System.out.println("Smallest: " + minPQ.peek());

        while (!minPQ.isEmpty()) {
            System.out.print(minPQ.poll() + " ");
        }

        System.out.println("\n");

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        maxPQ.offer(40);
        maxPQ.offer(10);
        maxPQ.offer(30);
        maxPQ.offer(5);
        maxPQ.offer(20);

        System.out.println("Max Priority Queue");
        System.out.println("Largest: " + maxPQ.peek());

        while (!maxPQ.isEmpty()) {
            System.out.print(maxPQ.poll() + " ");
        }

        System.out.println();
    }
}