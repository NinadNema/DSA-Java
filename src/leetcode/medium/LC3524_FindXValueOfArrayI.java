package leetcode.medium;

import java.util.Arrays;

public class LC3524_FindXValueOfArrayI {
    public static void main(String[] args) {
        LC3524_FindXValueOfArrayI lc = new LC3524_FindXValueOfArrayI();

        int[] nums = {1,2,3,4,5};
        int k = 5;

        System.out.println(Arrays.toString(lc.resultArray(nums, k)));
    }

//  Time Complexity - O(n*k)
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];

        long[] dp = new long[k];

        for (int num : nums) {

            long[] next = new long[k];

            int value = num % k;

            next[value]++;

            for (int r = 0; r < k; r++) {
                if (dp[r] > 0) {
                    int newRemainder = (r * value) % k;
                    next[newRemainder] += dp[r];
                }
            }

            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            dp = next;
        }

        return result;
    }
}
