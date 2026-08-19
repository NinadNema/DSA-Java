package linkedlist;


public class MergeSortLinkedList {
    public static void main(String[] args) {
        MergeSortLinkedList ll = new MergeSortLinkedList();
        ll.insertEnd(4);
        ll.insertEnd(2);
        ll.insertEnd(1);
        ll.insertEnd(3);

        ll.display();

        System.out.println(ll.mergeSort(ll.head).data);
    }

    private void insertEnd(int val){
        Node newNode = new Node(val);
        if(head == null){
            head = newNode;
        }else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    private void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("END");
    }

    private class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }
        Node(){}
    }
    private Node head = null;

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = mergeSort(head);
        Node right = mergeSort(mid);

        return merge(left, right);
    }

    public Node merge(Node left, Node right){
        Node dummpy = new Node();
        Node temp = dummpy;

        while(left != null && right != null){
            if(left.data < right.data){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        if(left != null){
            temp.next = left;
        }else{
            temp.next = right;
        }
        return dummpy.next;
    }

    public Node getMid(Node head){
        Node midPrev = null;
        while(head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return  mid;
    }
}
