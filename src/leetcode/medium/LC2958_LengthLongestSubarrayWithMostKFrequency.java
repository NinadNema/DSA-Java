package leetcode.medium;

import java.util.HashMap;

public class LC2958_LengthLongestSubarrayWithMostKFrequency {
    public static void main(String[] args){
        LC2958_LengthLongestSubarrayWithMostKFrequency lc = new LC2958_LengthLongestSubarrayWithMostKFrequency();
        int[] arr = {1,2,3,1,2,3,1,2};
        int k = 2;
        System.out.println(lc.maxSubarrayLength(arr, k));
    }

//  Time Complexity - O(n)
    public int maxSubarrayLength(int[] nums, int k){
        int left = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while(map.get(nums[right]) > k){
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
