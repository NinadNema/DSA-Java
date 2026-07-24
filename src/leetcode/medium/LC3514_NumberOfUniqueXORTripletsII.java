package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LC3514_NumberOfUniqueXORTripletsII {
    public static void main(String[] args) {
        int[] arr = {1,3};

        System.out.println(uniqueXorTriplets(arr));
    }
//    Brute Force - Time Complexity O(N^3)
    static int uniqueXorTriplets2(int[] nums){
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    int ans = nums[i] ^ nums[j] ^ nums[k];

                    list.add(ans);
                }
            }
        }

        return list.size();
    }
//    Approach 2 - Time Complexity O(N^2)
    static int uniqueXorTriplets(int[] nums){
        HashSet<Integer> list = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                list.add(nums[i] ^ nums[j]);
            }
        }

        Set<Integer> s2 = new HashSet<>();
        for(int pair : list){
            for(int num : nums){
                s2.add(pair ^ num);
            }
        }

        return s2.size();
    }
}
