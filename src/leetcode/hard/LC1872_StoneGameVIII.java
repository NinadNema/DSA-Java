package leetcode.hard;

public class LC1872_StoneGameVIII {
    public static void main(String[] args) {
        LC1872_StoneGameVIII lc = new LC1872_StoneGameVIII();

        int[] nums = {-1,2,-3,4,-5};
        System.out.println(lc.stoneGameVIII(nums));
    }

//  Time Complexity - O(n)
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        long[] prefix = new long[n];

        prefix[0] = stones[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        long[] dp = new long[n];

        dp[n - 1] = prefix[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(
                    dp[i + 1],
                    prefix[i] - dp[i + 1]
            );
        }

        return (int) dp[1];
    }
}
