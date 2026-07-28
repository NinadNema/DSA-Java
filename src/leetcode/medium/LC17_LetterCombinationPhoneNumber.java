package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
public class LC17_LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

//    Time Complexity - O(4^n × n)
    static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()) {
            return ans;
        }

        String[] map = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve("", digits, map, ans);

        return ans;
    }

    static void solve(String p, String up, String[] map, List<String> ans) {

        if (up.isEmpty()) {
            ans.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            solve(p + letters.charAt(i), up.substring(1), map, ans);
        }
    }
}
