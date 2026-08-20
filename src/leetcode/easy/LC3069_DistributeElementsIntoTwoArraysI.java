package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;

public class LC3069_DistributeElementsIntoTwoArraysI {
    public static void main(String[] args) {
        LC3069_DistributeElementsIntoTwoArraysI lc = new LC3069_DistributeElementsIntoTwoArraysI();

        int[] nums = {5,4,3,8};
        System.out.println(Arrays.toString(lc.resultArray(nums)));
    }

//  Time Complexity - O(N)
    public int[] resultArray(int[] nums){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < nums.length; i++) {
            if(arr1.getLast() > arr2.getLast()){
                arr1.add(nums[i]);
            }else{
                arr2.add(nums[i]);
            }
        }

        int j = 0;

        for (Integer integer : arr1) {
            nums[j++] = integer;
        }
        for (Integer integer : arr2) {
            nums[j++] = integer;
        }

        return nums;
    }
}
