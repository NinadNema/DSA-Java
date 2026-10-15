package leetcode.easy;

import java.util.HashMap;

public class LC219_ContainsDuplicateII {
    public static void main(String[] args) {
        LC219_ContainsDuplicateII lc = new LC219_ContainsDuplicateII();

        int[] nums = {1,0,1,1};

        System.out.println(lc.containsNearbyDuplicate(nums, 1));
    }

//  Time Complexity - O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i], i);
            }else{
                if(Math.abs(map.get(nums[i]) - i) <= k){
                  return true;
                }else{
                    map.put(nums[i], i);
                }
            }
        }

        return false;
    }
}
