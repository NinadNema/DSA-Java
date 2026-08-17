package leetcode.hard;

import java.util.Arrays;

public class LC1563_StoneGameV {
    public static void main(String[] args) {
        LC1563_StoneGameV lc = new LC1563_StoneGameV();

        int[] arr = {6,2,3,4,5,5};

        System.out.println(lc.stoneGameV(arr));
    }

//  Time Complexity - O(n^3)

    public int stoneGameV(int[] stoneValue){
        int n = stoneValue.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, prefix, dp);
    }

    static int solve(int left, int right, int[] prefix, int[][] dp) {

        if (left == right) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int ans = 0;

        for (int i = left; i < right; i++) {

            int leftSum = prefix[i + 1] - prefix[left];

            int rightSum = prefix[right + 1] - prefix[i + 1];

            if (leftSum < rightSum) {
                ans = Math.max(ans, leftSum + solve(left, i, prefix, dp));
            } else if (rightSum < leftSum) {
                ans = Math.max(ans, rightSum + solve(i + 1, right, prefix, dp));

            } else {
                ans = Math.max(ans, Math.max(leftSum + solve(left, i, prefix, dp), rightSum + solve(i + 1, right, prefix, dp)));
            }
        }

        dp[left][right] = ans;

        return ans;
    }
}
