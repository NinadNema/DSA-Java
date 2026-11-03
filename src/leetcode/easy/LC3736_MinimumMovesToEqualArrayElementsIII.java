package leetcode.easy;

public class LC3736_MinimumMovesToEqualArrayElementsIII {
    public static void main(String[] args) {
        LC3736_MinimumMovesToEqualArrayElementsIII lc = new LC3736_MinimumMovesToEqualArrayElementsIII();

        int[] nums = {2, 1, 3};

        System.out.println(lc.minMoves(nums));
    }

//  Time Complexity - O(N)
    public int minMoves(int[] nums) {
        int max = nums[0];

        for(int num : nums){
            max = Math.max(max, num);
        }

        int moves = 0;
        for(int num : nums){
            moves += max - num;
        }

        return moves;
    }
}
