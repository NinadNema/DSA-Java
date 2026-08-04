package leetcode.easy;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC3731_FindMissingElements {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5};

        System.out.println(findMissingElements(arr));
        System.out.println(findMissingElements2(arr));
    }

//    Approach 1 Sort + Comparing Adjacent Element - O(N log(N))
    static List<Integer> findMissingElements(int[] nums){

        Arrays.sort(nums);

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = nums[i] + 1; j < nums[i + 1]; j++) {
                ans.add(j);
            }
        }

        return ans;
    }

//    Approach 2 - Using HashSet - O(N)
    static List<Integer> findMissingElements2(int[] nums){
        int min = nums[0];
        int max = nums[0];

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
