package leetcode.hard;

import java.util.*;

public class LC2911_MinimumChangesToMakeKSemiPalindromes {
    public static void main(String[] args) {
        LC2911_MinimumChangesToMakeKSemiPalindromes lc = new LC2911_MinimumChangesToMakeKSemiPalindromes();

        String s = "abcac";
        int k = 2;

        System.out.println(lc.minimumChanges(s, k));
    }

//  Time Complexity - O(n³ log n)
    public int minimumChanges(String s, int k) {
        int n = s.length();
        final int INF = 1_000_000;
        char[] c = s.toCharArray();

        List<List<Integer>> divs = new ArrayList<>();
        for (int len = 0; len <= n; len++) divs.add(new ArrayList<>());
        for (int len = 2; len <= n; len++) {
            for (int d = 1; d < len; d++) {
                if (len % d == 0) divs.get(len).add(d);
            }
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (len == 1) {
                    cost[i][j] = INF;
                    continue;
                }
                int best = INF;
                for (int d : divs.get(len)) {
                    int changes = 0;
                    int groupSize = len / d;
                    for (int r = 0; r < d; r++) {
                        // group elements: i + r + t*d, t = 0..groupSize-1
                        int lo = 0, hi = groupSize - 1;
                        while (lo < hi) {
                            if (c[i + r + lo * d] != c[i + r + hi * d]) changes++;
                            lo++;
                            hi--;
                        }
                    }
                    best = Math.min(best, changes);
                }
                cost[i][j] = best;
            }
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int t = 1; t <= k; t++) {
            for (int j = 2 * t; j <= n; j++) {
                for (int i = 2 * (t - 1); i <= j - 2; i++) {
                    if (dp[t - 1][i] >= INF) continue;
                    int v = dp[t - 1][i] + cost[i][j - 1];
                    if (v < dp[t][j]) dp[t][j] = v;
                }
            }
        }
        return dp[k][n];
    }
}
