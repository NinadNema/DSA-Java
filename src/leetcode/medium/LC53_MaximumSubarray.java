package leetcode.medium;

public class LC53_MaximumSubarray {
    public static void main(String[] args) {
        LC53_MaximumSubarray lc = new LC53_MaximumSubarray();

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(lc.maxSubArray(nums));
    }

//  Time Complexity - O(n)
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
}
