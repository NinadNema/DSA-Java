package leetcode.easy;

public class LC1021_RemoveOutermostParentheses {
    public static void main(String[] args) {
        LC1021_RemoveOutermostParentheses lc = new LC1021_RemoveOutermostParentheses();

        String s = "(()())(())";

        System.out.println(lc.removeOuterParentheses(s));
    }

//  Time Complexity - O(n)
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int balance = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                if (balance > 0) {
                    ans.append(ch);
                }
                balance++;
            } else {
                balance--;

                if (balance > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}
