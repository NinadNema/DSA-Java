package leetcode.medium;

public class LC209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        LC209_MinimumSizeSubarraySum lc = new LC209_MinimumSizeSubarraySum();

        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(lc.minSubArrayLen(target, nums));
    }

//  Time Complexity - O(n)
    public int minSubArrayLen(int target, int[] nums) {
        int minCount = Integer.MAX_VALUE;
        int sum = 0;

        int i = 0;
        int j = 0;

        while(j < nums.length){
            sum += nums[j];
            while(sum >= target){
                minCount = Math.min(minCount, j - i + 1);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return minCount == Integer.MAX_VALUE ? 0 : minCount;
    }
}
