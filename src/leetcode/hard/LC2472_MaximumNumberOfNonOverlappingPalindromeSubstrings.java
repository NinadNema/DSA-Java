package leetcode.hard;

public class LC2472_MaximumNumberOfNonOverlappingPalindromeSubstrings {
    public static void main(String[] args) {
        LC2472_MaximumNumberOfNonOverlappingPalindromeSubstrings lc = new LC2472_MaximumNumberOfNonOverlappingPalindromeSubstrings();

        String s = "abaccdbbd";
        int k = 3;

        System.out.println(lc.maxPalindromes(s, k));
    }

//  Time Complexity - O(n^2)
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int left = 0; left + len <= n; left++) {

                int right = left + len - 1;

                if (s.charAt(left) == s.charAt(right) && (len <= 2 || palindrome[left + 1][right - 1])) {
                    palindrome[left][right] = true;
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i - 1];

            for (int j = 0; j < i; j++) {

                if (i - j >= k && palindrome[j][i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }
}