package leetcode.easy;

import java.util.*;

public class LC3471_FindtheLargestAlmostMissingInteger {
    public static void main(String[] args) {
        LC3471_FindtheLargestAlmostMissingInteger lc = new LC3471_FindtheLargestAlmostMissingInteger();
        int[] arr = {1,1,2};
        System.out.println(lc.largestInteger(arr, 3));
    }

//  Time Complexity - O(n * k)
    public int largestInteger(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i + k <= nums.length; i++) {

            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }

            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int max = -1;

        for (int num : nums) {
            if (map.getOrDefault(num, 0) == 1) {
                max = Math.max(max, num);
            }
        }

        return max;
    }
}
