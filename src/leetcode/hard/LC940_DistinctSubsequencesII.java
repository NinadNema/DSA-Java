package leetcode.hard;

import java.util.ArrayList;

public class LC940_DistinctSubsequencesII {
    public static void main(String[] args) {
        LC940_DistinctSubsequencesII lc = new LC940_DistinctSubsequencesII();

        String s = "abc";
        System.out.println(lc.distinctSubseqII(s));
    }

//  Time Complexity - O(n)
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        int[] last = new int[26];

        int dp = 1;

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';

            int newDp = (2 * dp % MOD - last[index] + MOD) % MOD;

            last[index] = dp;

            dp = newDp;
        }

        return (dp - 1 + MOD) % MOD;
    }
}
