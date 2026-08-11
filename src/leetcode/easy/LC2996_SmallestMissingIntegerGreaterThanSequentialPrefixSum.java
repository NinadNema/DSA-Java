package leetcode.easy;

import java.util.HashSet;

public class LC2996_SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public static void main(String[] args){
        LC2996_SmallestMissingIntegerGreaterThanSequentialPrefixSum lc = new LC2996_SmallestMissingIntegerGreaterThanSequentialPrefixSum();

        int[] arr = {3,4,5,1,12,14,13};
        System.out.println(lc.missingInteger(arr));
    }

//  Time Complexity: O(n)
    public int missingInteger(int[] nums) {
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1){
                sum += nums[i];
            }else{
                break;
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        while(set.contains(sum)){
            sum++;
        }

        return sum;
    }
}
