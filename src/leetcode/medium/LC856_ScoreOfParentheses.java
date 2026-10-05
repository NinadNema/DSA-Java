package leetcode.medium;

import java.util.Stack;

public class LC856_ScoreOfParentheses {
    public static void main(String[] args) {
        LC856_ScoreOfParentheses lc = new LC856_ScoreOfParentheses();

        String s = "()()";

        System.out.println(lc.scoreOfParentheses(s));
    }

//  Time Complexity - O(n)
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int inner = stack.pop();

                int score;
                if (inner == 0) {
                    score = 1;
                } else {
                    score = 2 * inner;
                }

                stack.push(stack.pop() + score);
            }
        }

        return stack.pop();
    }
}
