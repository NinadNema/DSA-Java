package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2089_FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        LC2089_FindTargetIndicesAfterSortingArray lc = new LC2089_FindTargetIndicesAfterSortingArray();

        int[] nums = {1,2,5,2,3};
        int target = 2;

        System.out.println(lc.targetIndices(nums, target));
    }

//  Time Complexity - O(n log n)
    public List<Integer> targetIndices(int[] nums, int target) {
        ArrayList<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target){
                ans.add(i);
            }
        }

        return ans;
    }
}
