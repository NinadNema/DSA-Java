package leetcode.medium;

import java.util.Arrays;

public class LC2747_CountZeroRequestServers {
    public static void main(String[] args) {
        LC2747_CountZeroRequestServers lc = new LC2747_CountZeroRequestServers();

        int n = 3;
        int[][] logs = {{1,3}, {2, 6}, {1, 5}};
        int x = 5;
        int[] queries = {10, 11};

        System.out.println(Arrays.toString(lc.countServers(n, logs, x, queries)));
    }

//  Time Complexity - O(L log L + Q log Q)
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] qs = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }

        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];
        int[] count = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int[] q : qs) {
            int time = q[0];
            int start = time - x;

            while (right < logs.length &&
                    logs[right][1] <= time) {

                int server = logs[right][0];

                if (count[server] == 0) {
                    active++;
                }

                count[server]++;
                right++;
            }

            while (left < right &&
                    logs[left][1] < start) {

                int server = logs[left][0];

                count[server]--;

                if (count[server] == 0) {
                    active--;
                }

                left++;
            }

            ans[q[1]] = n - active;
        }

        return ans;
    }
}
