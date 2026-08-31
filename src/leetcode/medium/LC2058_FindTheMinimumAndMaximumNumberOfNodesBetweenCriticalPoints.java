package leetcode.medium;

import java.util.ArrayList;

public class LC2058_FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

//  Time Complexity - O(n)
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;

        int index = 2;

        ArrayList<Integer> list = new ArrayList<>();

        while (curr.next != null) {

            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val)) {

                list.add(index);
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            minDistance = Math.min(minDistance, list.get(i) - list.get(i - 1));
        }

        int maxDistance = list.getLast() - list.getFirst();

        return new int[]{minDistance, maxDistance};
    }
}
