package leetcode.easy;

public class LC83_RemoveDuplicatesfromSortedList {

    private ListNode head = null;
    int size = 0;

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void insertionBegin(int data){
        ListNode newNode = new ListNode(data);

        newNode.next = head;
        head = newNode;

        size++;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while(temp != null && temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }

        return head;
    }

    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LC83_RemoveDuplicatesfromSortedList lc = new LC83_RemoveDuplicatesfromSortedList();
        lc.insertionBegin(2);
        lc.insertionBegin(1);
        lc.insertionBegin(1);

        System.out.println("Before: ");
        lc.display();

        lc.head = lc.deleteDuplicates(lc.head);

        System.out.println("After: ");
        lc.display();
    }
}
