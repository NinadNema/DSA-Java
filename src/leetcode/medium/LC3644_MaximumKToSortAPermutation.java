package leetcode.medium;

public class LC3644_MaximumKToSortAPermutation {
    public static void main(String[] args) {
        LC3644_MaximumKToSortAPermutation lc = new LC3644_MaximumKToSortAPermutation();

        int[] nums = {0,3,2,1};

        System.out.println(lc.sortPermutation(nums));
    }

//  Time Complexity - O(n)
    public int sortPermutation(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                if (k == -1) {
                    k = nums[i];
                } else {
                    k &= nums[i];
                }
            }
        }

        if (k == -1) {
            return 0;
        }

        return k;
    }
}
