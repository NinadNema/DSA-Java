package leetcode.medium;

import java.util.Stack;

public class LC1190_ReverseSubstringsBetweenEachPairOfParentheses {
    public static void main(String[] args) {
        LC1190_ReverseSubstringsBetweenEachPairOfParentheses lc = new LC1190_ReverseSubstringsBetweenEachPairOfParentheses();

        String s = "(u(love)i)";

        System.out.println(lc.reverseParentheses(s));
    }

//  Time Complexity - O(n^2)
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                stack.push(current);
                current = new StringBuilder();

            } else if (ch == ')') {

                current.reverse();

                StringBuilder previous = stack.pop();
                previous.append(current);

                current = previous;

            } else {

                current.append(ch);
            }
        }

        return current.toString();
    }
}
