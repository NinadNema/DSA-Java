package linkedlist;

public class SinglyLinkedList {
    private Node head;
    private Node tail;

    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insertionBegin(int data){
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertEnd(int data){
        if(tail == null){
            insertionBegin(data);
            return;
        }

        Node newNode = new Node(data);

        tail.next = newNode;
        tail = newNode;

        size++;
    }

    public void insertionPosition(int data, int idx){
        Node newNode = new Node(data);

        Node temp = head;

        if(idx == 0){
            insertionBegin(data);
            return;
        }

        if(idx == size){
            insertEnd(data);
            return;
        }

        for (int i = 1; i < idx; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void insertRec(int data, int index){
        if(index == 0){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode ;
            return;
        }


        head = insertRec(data, index - 1, head);
    }

    private Node insertRec(int data, int index, Node node){
        if(index == 0){
            Node newNode = new Node(data);
            newNode.next = node;
            return newNode;
        }

        node.next = insertRec(data, index - 1, node.next);

        return node;
    }

    public int deleteBegin(){
        int val = head.data;
        head = head.next;

        if(head == null) {
            tail = null;
        }

        size--;
        return val;
    }

    public int deleteEnd(){

        if(size <= 1){
            return deleteBegin();
        }

        Node secondLast = get(size - 2);
        int val = tail.data;
        tail = secondLast;
        tail.next = null;

        size--;
        return val;
    }

    public int deletePosition(int idx){
        if(idx == 0){
            return deleteBegin();
        }

        if(idx == size - 1){
            return deleteEnd();
        }

        Node prev = get(idx - 1);
        int val = prev.next.data;

        prev.next = prev.next.next;

        size--;
        return val;
    }

    public int find(int value){
        Node temp = head;
        int index = 0;

        while(temp != null){
            if(temp.data == value){
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    public Node get(int index){
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
    }
}
