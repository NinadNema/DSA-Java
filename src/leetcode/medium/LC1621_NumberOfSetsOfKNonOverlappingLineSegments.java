package leetcode.medium;

public class LC1621_NumberOfSetsOfKNonOverlappingLineSegments {
    public static void main(String[] args) {
        LC1621_NumberOfSetsOfKNonOverlappingLineSegments lc = new LC1621_NumberOfSetsOfKNonOverlappingLineSegments();

        int n = 4;
        int k = 2;

        System.out.println(lc.numberOfSets(n, k));
    }

//  Time Complexity - O(n * k)
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[k + 1][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int j = 1; j <= k; j++) {
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    sum = (sum + dp[j - 1][i - 1]) % MOD;
                }

                dp[j][i] = (dp[j][Math.max(i - 1, 0)] + sum) % MOD;
            }
        }

        return (int) dp[k][n - 1];
    }
}
