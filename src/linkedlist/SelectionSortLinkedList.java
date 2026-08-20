package linkedlist;

public class SelectionSortLinkedList {
    public static void main(String[] args) {
        SelectionSortLinkedList ss = new SelectionSortLinkedList();

        ss.insert(2);
        ss.insert(4);
        ss.insert(1);
        ss.insert(3);

        ss.selectionSort();
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

    private void insert(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    private void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void selectionSort(){
        Node current = head;

        while(current != null){
            Node min = current;
            Node temp = current.next;

            while(temp != null){
                if(temp.val < min.val){
                    min = temp;
                }

                temp = temp.next;
            }

            int tempVal = current.val;
            current.val = min.val;
            min.val = tempVal;

            current = current.next;
        }

        display();
    }
}
