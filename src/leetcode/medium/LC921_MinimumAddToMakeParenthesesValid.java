package leetcode.medium;

import java.util.Stack;

public class LC921_MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        LC921_MinimumAddToMakeParenthesesValid lc = new LC921_MinimumAddToMakeParenthesesValid();

        String s = "(((";

        System.out.println(lc.minAddToMakeValid(s));
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
                count++;
            }else{
                if(ch == ')'){
                   if(!stack.isEmpty()) {
                       stack.pop();
                       count--;
                   }else{
                       count++;
                   }
                }
            }
        }

        return count;
    }
}
