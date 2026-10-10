package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class LC1_TwoSum {
    public static void main(String[] args) {
        LC1_TwoSum lc = new LC1_TwoSum();

        int[] nums = {2,7,11,15};

        System.out.println(Arrays.toString(lc.twoSum(nums, 9)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int c = target - nums[i];

            if(map.containsKey(c)){
                return new int[] {map.get(c), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
