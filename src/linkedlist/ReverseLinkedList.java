package linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList rl = new ReverseLinkedList();

        rl.insert(5);
        rl.insert(4);
        rl.insert(3);
        rl.insert(2);
        rl.insert(1);

        rl.display();

        rl.reverseRec(rl.head);
        rl.reverse();

        rl.display();
    }

    private class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private void insert(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    private void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

//  Reversing Linked List using Recursion
//  Time Complexity - O(n)
    public void reverseRec(Node node){
        if(node == tail){
            head = tail;
            return;
        }

        reverseRec(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

//  Reverse Linked List using Iteration
//  Time Complexity - O(n)
    public void reverse(){
        if(size < 2){
            return;
        }

        Node prev = null;
        Node pres = head;
        Node next = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) {
                next = next.next;
            }
        }
        head = prev;
    }
}
