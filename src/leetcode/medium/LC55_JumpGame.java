package leetcode.medium;

public class LC55_JumpGame {
    public static void main(String[] args) {
        LC55_JumpGame lc = new LC55_JumpGame();

        int[] nums = {2,3,1,1,4};

        System.out.println(lc.canJump(nums));
    }

//  Time Complexity - O(n)
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] + i >= n){
                n = i;
            }
        }

        return n == 0;
    }
}
