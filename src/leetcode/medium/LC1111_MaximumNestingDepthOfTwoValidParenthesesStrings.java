package leetcode.medium;

import java.util.Arrays;

public class LC1111_MaximumNestingDepthOfTwoValidParenthesesStrings {
    public static void main(String[] args) {
        LC1111_MaximumNestingDepthOfTwoValidParenthesesStrings lc = new LC1111_MaximumNestingDepthOfTwoValidParenthesesStrings();

        String s = "(()())";

        System.out.println(Arrays.toString(lc.maxDepthAfterSplit(s)));
    }

//  Time Complexity - O(n)
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int[] nums = new int[seq.length()];

        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if(c == '('){
                depth++;
                nums[i] = depth % 2;
            } else {
                nums[i] = depth % 2;
                depth--;
            }
        }

        return nums;
    }
}
