package leetcode.medium;

import java.util.Arrays;

public class LC167_TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        LC167_TwoSumIIInputArrayIsSorted lc = new LC167_TwoSumIIInputArrayIsSorted();

        int[] nums = {5,25,75};
        int[] nums1 = {2,3,4};
        int target = 6;
        int target1 = 100;

        System.out.println(Arrays.toString(lc.twoSum(nums, target1)));
        System.out.println(Arrays.toString(lc.twoSum(nums1, target)));
    }

//  Method 1 : Using Two Pointer
//  Time Complexity - O(n)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{};
    }

//  Method 2: Using Binary Search
//  Time Complexity - O(n log n)
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        while(i < numbers.length){
            int diff = target - numbers[i];
            int idx = binarysearch(i + 1, numbers.length - 1, diff, numbers);
            if(idx == -1){
                i++;
            }else{
                return new int[]{i + 1, idx + 1};
            }
        }
        return new int[]{};
    }

    private int binarysearch(int s, int e, int tar, int[] nums){
        while(s <= e){
            int mid = s + (e - s)/2;

            if(nums[mid] == tar){
                return mid;
            }
            if(tar > nums[mid]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return -1;
    }
//  Method 3: Brute Force
//  Time Complexity - O(n ^ 2)
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if(sum == target){
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return new int[]{};
    }
}
