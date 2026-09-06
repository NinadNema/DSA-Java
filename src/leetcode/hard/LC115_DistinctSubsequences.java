package leetcode.hard;

public class LC115_DistinctSubsequences {
    public static void main(String[] args) {
        LC115_DistinctSubsequences lc = new LC115_DistinctSubsequences();

        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(lc.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
