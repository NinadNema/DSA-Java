package leetcode.medium;

import java.util.Arrays;

public class LC462_MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        LC462_MinimumMovesToEqualArrayElementsII lc = new LC462_MinimumMovesToEqualArrayElementsII();

        int[] nums = {1, 10, 2, 9};

        System.out.println(lc.minMoves2(nums));
    }

//  Time Complexity - O(n log n)
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int median = nums[nums.length / 2];

        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }
}
