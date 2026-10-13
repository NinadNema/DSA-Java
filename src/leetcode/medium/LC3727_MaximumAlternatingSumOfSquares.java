package leetcode.medium;

import java.util.Arrays;

public class LC3727_MaximumAlternatingSumOfSquares {
    public static void main(String[] args) {
        LC3727_MaximumAlternatingSumOfSquares lc = new LC3727_MaximumAlternatingSumOfSquares();

        int[] nums = {1,2,3};

        System.out.println(lc.maxAlternatingSum(nums));
    }

//  Time Complexity - O(n log n)
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(nums[i], 2);
        }

        Arrays.sort(nums);

        long nn = nums.length / 2;
        long sum = 0;

        for (int i = nums.length - 1; i >= nn ; i--) {
            sum += nums[i];
        }

        for (int i = 0; i < nn; i++) {
            sum -= nums[i];
        }

        return sum;
    }
}
