package leetcode.medium;

public class LC3693_ClimbingStairsII {
    public static void main(String[] args) {
        LC3693_ClimbingStairsII lc = new LC3693_ClimbingStairsII();

        int n = 4;
        int[] costs = {1,2,3,4};

        System.out.println(lc.climbStairs(n, costs));
    }

//  Time Complexity - O(n)
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dp[i] = Integer.MAX_VALUE;

            for (int j = 1; j <= 3; j++) {

                if (i - j >= 0) {

                    int jumpCost = j * j;
                    int cost = costs[i - 1] + jumpCost;

                    dp[i] = Math.min(dp[i], dp[i - j] + cost);
                }
            }
        }

        return dp[n];
    }
}
