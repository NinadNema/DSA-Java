package leetcode.medium;

import java.util.Arrays;

public class LC1658_MinimumOperationsToReduceXToZero {
    public static void main(String[] args) {
        LC1658_MinimumOperationsToReduceXToZero lc = new LC1658_MinimumOperationsToReduceXToZero();

        int[] nums = {1,1,4,2,3};
        int x = 5;

        System.out.println(lc.minOperations(nums, x));
    }

//  Time Complexity - O(n)
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            while (sum > target) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }

//  Time Complexity - O(2^n)
    public int minOperations2(int[] nums, int x) {
        int ans = hepler(nums, x, 0);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }else{
            return ans;
        }
    }

    private int hepler(int[] nums, int x, int count){
        if(x == 0){
            return count;
        }

        if(nums.length == 0 || x < 0){
            return Integer.MAX_VALUE;
        }

        int left = hepler(Arrays.copyOfRange(nums, 1, nums.length), x - nums[0], count + 1);
        int right = hepler(Arrays.copyOfRange(nums, 0, nums.length - 1), x - nums[nums.length - 1], count + 1);

        return Math.min(left, right);
    }
}
