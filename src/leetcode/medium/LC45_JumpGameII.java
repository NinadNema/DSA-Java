package leetcode.medium;

public class LC45_JumpGameII {
    public static void main(String[] args) {
        LC45_JumpGameII lc = new LC45_JumpGameII();

        int[] nums = {2,3,1,1,4};

        System.out.println(lc.jump(nums));
    }


//  Time Complexity - O(n)
    public int jump(int[] nums) {
        int farthest = 0;
        int currentEnd = 0;
        int jump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if( i == currentEnd){
                jump++;
                currentEnd = farthest;
            }
        }

        return jump;
    }
}
