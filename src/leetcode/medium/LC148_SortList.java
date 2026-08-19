package leetcode.medium;

public class LC148_SortList {
    public static void main(String[] args) {
        LC148_SortList ll = new LC148_SortList();

        System.out.println(ll.sortList(ll.head).val);
    }

    private class ListNode {
        private int val;
        private ListNode next;

        ListNode(int data) {
            this.val = data;
        }
        ListNode(){}
    }
    private ListNode head = null;

//  Time Complexity - O(N log N)
    public ListNode sortList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode dummpy = new ListNode();
        ListNode temp = dummpy;

        while(left != null && right != null){
            if(left.val < right.val){
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

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return slow;
    }
}
