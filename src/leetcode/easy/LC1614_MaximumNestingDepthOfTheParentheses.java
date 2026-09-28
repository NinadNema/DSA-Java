package leetcode.easy;

import java.util.Stack;

public class LC1614_MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        LC1614_MaximumNestingDepthOfTheParentheses lc = new LC1614_MaximumNestingDepthOfTheParentheses();

        String s = "()(())((()()))";

        System.out.println(lc.maxDepth(s));
    }

//  Method 1: Optimal Approach, Time Complexity - O(n) and Space Complexity - O(1)
    public int maxDepth(String s) {
        int count = 0;
        int maxCount = 0;
        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) == '('){
                count++;
            }else if (s.charAt(i) == ')'){
                count--;
            }

            maxCount = Math.max(maxCount, count);
            i++;
        }

        return maxCount;
    }



//  Method 2: Using Stack, Time Complexity - O(n) and Space Complexity - O(n)
    public int maxDepth2(String s) {
        Stack<Character> stack = new Stack<>();

        int count = 0;
        int maxCount = 0;

        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '('){
                stack.push('(');
                count++;
            }else if(s.charAt(i) == ')'){
                stack.pop();
                count--;
            }

            maxCount = Math.max(count, maxCount);
            i++;
        }

        return maxCount;
    }
}
