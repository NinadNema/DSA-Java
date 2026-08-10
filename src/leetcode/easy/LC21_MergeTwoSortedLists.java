package leetcode.easy;

public class LC21_MergeTwoSortedLists {
    private ListNode head = null;
    private ListNode tail = null;
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) { this.val = val; }
    }

    public void insertionBegin(int data){
        ListNode newNode = new ListNode(data);

        newNode.next = head;
        head = newNode;

        if(tail == null) {
            tail = head;
        }
    }

    public void insertEnd(int data){
        if(tail == null){
            insertionBegin(data);
            return;
        }

        ListNode newNode = new ListNode(data);

        tail.next = newNode;
        tail = newNode;
    }

    public void display() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    public void mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;

        LC21_MergeTwoSortedLists ans = new LC21_MergeTwoSortedLists();

        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                ans.insertEnd(head1.val);
                head1 = head1.next;
            }else{
                ans.insertEnd(head2.val);
                head2 = head2.next;
            }
        }

        while(head1 != null){
            ans.insertEnd(head1.val);
            head1 = head1.next;
        }
        while(head2 != null){
            ans.insertEnd(head2.val);
            head2 = head2.next;
        }

        ans.display();
    }

    public static void main(String[] args) {
        LC21_MergeTwoSortedLists lc1 = new LC21_MergeTwoSortedLists();

        lc1.insertEnd(1);
        lc1.insertEnd(2);
        lc1.insertEnd(4);

        lc1.display();
        LC21_MergeTwoSortedLists lc2 = new LC21_MergeTwoSortedLists();

        lc2.insertEnd(1);
        lc2.insertEnd(3);
        lc2.insertEnd(4);
        lc2.display();

        LC21_MergeTwoSortedLists lc = new LC21_MergeTwoSortedLists();
        lc.mergeTwoLists(lc1.head, lc2.head);
    }
}
