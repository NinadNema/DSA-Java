package arrays;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {3,5,5,6,};
        System.out.println(Arrays.toString(twoSum(arr, 10)));
    }

    static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] {};
    }
}