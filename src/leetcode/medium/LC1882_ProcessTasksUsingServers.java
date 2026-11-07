package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC1882_ProcessTasksUsingServers {
    public static void main(String[] args) {
        LC1882_ProcessTasksUsingServers lc = new LC1882_ProcessTasksUsingServers();

        int[] server = {3,3,2};
        int[] tasks = {1,2,3,2,1,2};

        System.out.println(Arrays.toString(lc.assignTasks(server, tasks)));
    }

//  Time Complexity - O((n + m) log n)
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> {
                    if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                    return Integer.compare(a[1], b[1]);
                }
        );

        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> {
                    if (a[0] != b[0]) return Integer.compare(a[0], b[0]);

                    if (a[1] != b[1]) return Integer.compare(a[1], b[1]);

                    return Integer.compare(a[2], b[2]);
                }
        );

        for (int i = 0; i < n; i++) {
            free.offer(new int[]{servers[i], i});
        }

        int[] ans = new int[m];

        long time = 0;

        for (int j = 0; j < m; j++) {

            time = Math.max(time, j);

            while (!busy.isEmpty() && busy.peek()[0] <= time) {
                int[] server = busy.poll();

                free.offer(new int[]{server[1], server[2]});
            }

            if (free.isEmpty()) {
                time = busy.peek()[0];

                while (!busy.isEmpty() && busy.peek()[0] <= time) {
                    int[] server = busy.poll();

                    free.offer(new int[]{server[1], server[2]});
                }
            }

            int[] server = free.poll();

            int weight = server[0];
            int index = server[1];

            ans[j] = index;

            busy.offer(new int[]{(int)(time + tasks[j]), weight, index});
        }

        return ans;
    }
}
