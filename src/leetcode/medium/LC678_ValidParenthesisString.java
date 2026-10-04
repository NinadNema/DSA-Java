package leetcode.medium;

public class LC678_ValidParenthesisString {
    public static void main(String[] args) {
        LC678_ValidParenthesisString lc = new LC678_ValidParenthesisString();

        String s = "(*))";

        System.out.println(lc.checkValidString(s));
    }

//  Time Complexity - O(n)
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // '*'
                low--;
                high++;
            }

            if (high < 0) {
                return false;
            }

            low = Math.max(low, 0);
        }

        return low == 0;
    }
}
