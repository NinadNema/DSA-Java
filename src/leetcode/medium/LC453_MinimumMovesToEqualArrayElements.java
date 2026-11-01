package leetcode.medium;

public class LC453_MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        LC453_MinimumMovesToEqualArrayElements lc = new LC453_MinimumMovesToEqualArrayElements();

        int[] nums = {1, 2, 3};

        System.out.println(lc.minMoves(nums));
    }

//  Time Complexity - O(n)
    public int minMoves(int[] nums) {
        int min = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}
