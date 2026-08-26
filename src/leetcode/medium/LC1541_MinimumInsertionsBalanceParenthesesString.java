package leetcode.medium;

import java.util.Stack;

public class LC1541_MinimumInsertionsBalanceParenthesesString {
    public static void main(String[] args) {
        LC1541_MinimumInsertionsBalanceParenthesesString lc = new LC1541_MinimumInsertionsBalanceParenthesesString();

        String s = "(()))(()))()())))";

        System.out.println(lc.minInsertions(s));
    }

//  Time Complexity - O(n)
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(stack.isEmpty()){
                    stack.push(ch);
                }else{
                    if(stack.peek() == '('){
                        stack.push(ch);
                    }else {
                        count++;
                        stack.pop();
                        stack.pop();
                        stack.push(ch);
                    }
                }
            }else {
                if(stack.isEmpty()){
                    count++;
                    stack.push('(');
                    stack.push(ch);
                }else{
                    if(stack.peek() == '('){
                        stack.push(ch);
                    }else{
                        stack.pop();
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return count;
        }else{
            while(!stack.isEmpty()){
                char c = stack.pop();
                if(c == '('){
                    count += 2;
                }else{
                    count++;
                    stack.pop();
                }
            }
        }
        return count;
    }
}
