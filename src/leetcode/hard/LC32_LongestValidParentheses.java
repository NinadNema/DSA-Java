package leetcode.hard;

import java.util.Stack;

public class LC32_LongestValidParentheses {
    public static void main(String[] args) {
        LC32_LongestValidParentheses lc = new LC32_LongestValidParentheses();

        String s = "(()";

        System.out.println(lc.longestValidParentheses(s));
    }

//  Time Complexity - O(n)
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxCount = Math.max(maxCount, i - stack.peek());
                }
            }
        }

        return maxCount;
    }
}
