package leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC301_RemoveInvalidParentheses {
    public static void main(String[] args) {
        LC301_RemoveInvalidParentheses lc = new LC301_RemoveInvalidParentheses();

        String s = "()())()";

        System.out.println(lc.removeInvalidParentheses(s));
    }

//  Time Complexity - O(2^n)
    public List<String> removeInvalidParentheses(String s) {
        int removeLeft = 0;
        int removeRight = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                removeLeft++;
            } else if (ch == ')') {
                if (removeLeft > 0) {
                    removeLeft--;
                } else {
                    removeRight++;
                }
            }
        }

        Set<String> set = new HashSet<>();

        backtrack(s, 0, 0, removeLeft, removeRight, "", set);

        return new ArrayList<>(set);
    }

    private void backtrack(String s, int index, int balance, int removeLeft, int removeRight, String current, Set<String> set) {
        if (balance < 0) {
            return;
        }

        if (index == s.length()) {

            if (balance == 0 && removeLeft == 0 && removeRight == 0) {
                set.add(current);
            }

            return;
        }

        char ch = s.charAt(index);

        if (ch != '(' && ch != ')') {
            backtrack(s, index + 1, balance, removeLeft, removeRight, current + ch, set);
            return;
        }

        if (ch == '(' && removeLeft > 0) {
            backtrack(s, index + 1, balance, removeLeft - 1, removeRight, current, set);
        }

        if (ch == ')' && removeRight > 0) {
            backtrack(s, index + 1, balance, removeLeft, removeRight - 1, current, set);
        }

        if (ch == '(') {
            backtrack(s, index + 1, balance + 1, removeLeft, removeRight, current + ch, set);
        } else {
            backtrack(s, index + 1, balance - 1, removeLeft, removeRight, current + ch, set);
        }
    }
}
