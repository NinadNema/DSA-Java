package leetcode.easy;

public class LC206_ReverseLinkedList {
    class ListNode{
        int val;
        ListNode next;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode pres = head;

        while(pres != null){
            ListNode next = pres.next;

            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}
