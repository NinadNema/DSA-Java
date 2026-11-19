package leetcode.medium;

import java.util.Arrays;

public class LC2567_MinimumScoreByChangingTwoElements {
    public static void main(String[] args) {
        LC2567_MinimumScoreByChangingTwoElements lc = new LC2567_MinimumScoreByChangingTwoElements();

        int[] nums = new int[]{1, 4, 7, 8, 5};

        System.out.println(lc.minimizeSum(nums));
    }

//  Time Complexity - O(n log n)
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int option1 = nums[n - 1] - nums[2];
        int option2 = nums[n - 2] - nums[1];
        int option3 = nums[n - 3] - nums[0];

        return Math.min(option1, Math.min(option2, option3));
    }
}
