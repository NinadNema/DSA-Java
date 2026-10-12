package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class LC2897_ApplyOperationsOnArrayToMaximizeSumOfSquares {
    public static void main(String[] args) {
        LC2897_ApplyOperationsOnArrayToMaximizeSumOfSquares lc = new LC2897_ApplyOperationsOnArrayToMaximizeSumOfSquares();

        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(6);
        nums.add(5);
        nums.add(8);

        System.out.println(lc.maxSum(nums, 2));
    }

//  Time Complexity - O(n + k)
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;

        int[] bits = new int[31];

        for (int num : nums) {
            for (int b = 0; b < 31; b++) {
                if ((num & (1 << b)) != 0) {
                    bits[b]++;
                }
            }
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            long x = 0;

            for (int b = 30; b >= 0; b--) {
                if (bits[b] > 0) {
                    x |= (1L << b);
                    bits[b]--;
                }
            }

            ans = (ans + x * x) % MOD;
        }

        return (int) ans;
    }
}
