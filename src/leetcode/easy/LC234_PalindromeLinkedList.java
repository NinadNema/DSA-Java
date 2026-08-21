package leetcode.easy;

public class LC234_PalindromeLinkedList {
    public static void main(String[] args) {
        LC234_PalindromeLinkedList lc = new LC234_PalindromeLinkedList();

        lc.insert(1);
        lc.insert(2);
        lc.insert(2);
        lc.insert(1);

        System.out.println(lc.isPalindrome(lc.head));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
        }
    }

    private ListNode head = null;
    private ListNode tail = null;

    private void insert(int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode headSecond = reverse(mid);
        ListNode reverseHead = headSecond;

        while(head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }

        reverse(reverseHead);

        return head == null || headSecond == null;
    }

    public ListNode reverse(ListNode head){
        ListNode pres = head;
        ListNode prev = null;

        while(pres != null){
            ListNode next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }

    public ListNode getMid(ListNode head){
        ListNode f = head;
        ListNode s = head;

        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }
}
