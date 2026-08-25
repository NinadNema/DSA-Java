package leetcode.easy;

import java.util.Stack;

public class LC20_ValidParentheses {
    public static void main(String[] args) {
        LC20_ValidParentheses lc = new LC20_ValidParentheses();

        String s = "([])";

        System.out.println(lc.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char i : s.toCharArray()) {
            if (i == '{' || i == '(' || i == '[') {
                stack.push(i);
            }else{
                if(i == '}'){
                    if(stack.isEmpty() || stack.pop() != '{' ){
                        return false;
                    }
                }
                if(i == ')' ){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
                if(i == ']' ){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
