package leetcode.easy;

import java.util.List;
import java.util.ArrayList;

public class LC228_SummaryRanges {
    public static void main(String[] args) {
        LC228_SummaryRanges lc = new LC228_SummaryRanges();

        int[] nums = {0,1,2,4,5,7};

        System.out.println(lc.summaryRanges(nums));
    }

//  Time Complexity - O(n)
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while(i + 1 < nums.length && nums[i + 1] - nums[i] == 1){
                i++;
            }
            if(start != nums[i]){
                ans.add(start + "->" + nums[i]);
            }else{
                ans.add(String.valueOf(start));
            }
        }

        return ans;
    }
}
