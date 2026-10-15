package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC2913_SubarraysDistinctElementSumOfSquaresI {
    public static void main(String[] args) {
        LC2913_SubarraysDistinctElementSumOfSquaresI lc = new LC2913_SubarraysDistinctElementSumOfSquaresI();

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(1);

        System.out.println(lc.sumCounts(nums));
        System.out.println(lc.sumCounts2(nums));
    }

//  Method 1: Efficient Method
//  Time Complexity - O(n ^ 2)
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int count = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();

            for (int j = i; j < n; j++) {
                set.add(nums.get(j));

                int distinct = set.size();
                count += distinct * distinct;
            }
        }

        return count;
    }

//  Method 2: Exploring All Subarrays
//  Time Complexity - O(n ^ 3)
    public int sumCounts2(List<Integer> nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                List<Integer> list = new ArrayList<>();
                for (int k = i; k < j + 1; k++) {
                    list.add(nums.get(k));
                }
                ans.add(list);
            }
        }

        return helper(ans);
    }

    private int helper(List<List<Integer>> nums){
        int count = 0;

        for(List<Integer> num : nums){
            HashSet<Integer> ans = new HashSet<>();
            for (Integer integer : num) {
                ans.add(integer);
            }
            count += (int) Math.pow(ans.size(), 2);
        }

        return count;
    }
}
