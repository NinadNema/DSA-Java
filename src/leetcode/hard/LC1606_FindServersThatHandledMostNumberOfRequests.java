package leetcode.hard;

import java.util.*;

public class LC1606_FindServersThatHandledMostNumberOfRequests {
    public static void main(String[] args) {
        LC1606_FindServersThatHandledMostNumberOfRequests lc = new LC1606_FindServersThatHandledMostNumberOfRequests();

        int k = 3;
        int[] arrival = {1,2,3,4,5};
        int[] load = {5,2,3,3,3};

        System.out.println(lc.busiestServers(k, arrival, load));
    }

//  Time Complexity - O(n log k)
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);

        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            long start = arrival[i];

            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add((int) busy.poll()[1]);
            }

            if (free.isEmpty()) continue;

            Integer sid = free.ceiling(i % k);
            if (sid == null) sid = free.first();

            free.remove(sid);
            count[sid]++;
            busy.offer(new long[]{start + load[i], sid});
        }

        int max = 0;
        for (int c : count) max = Math.max(max, c);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) result.add(i);
        }
        return result;
    }
}
