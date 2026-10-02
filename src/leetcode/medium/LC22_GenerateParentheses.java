package leetcode.medium;

import java.util.List;
import java.util.ArrayList;

public class LC22_GenerateParentheses {
    public static void main(String[] args) {
        LC22_GenerateParentheses lc = new LC22_GenerateParentheses();

        int n = 3;

        System.out.println(lc.generateParenthesis(n));
    }

//  Time Complexity - O(2^n)
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        return helper(n, "", "", ans, 0);
    }

    private List<String> helper(int n, String s, String prev, ArrayList<String> ans, int balance){
        if(n == 0 ){
            if(balance != 0){
                for (int i = 0; i < balance; i++) {
                    s = s + ")";
                }
            }
            ans.add(s);
            return ans;
        }

        if(s.isEmpty()){
            return helper(n - 1, s + "(", "(", ans, balance + 1);
        }

        if(prev.equalsIgnoreCase("(")){
            helper(n - 1, s + "(", "(", ans, balance + 1);
            if(balance != 0) {
                helper(n, s + ")", ")", ans, balance - 1);
            }
        }else{
            helper(n - 1, s + "(", "(", ans, balance + 1);
            if(balance != 0) {
                helper(n, s + ")", ")", ans, balance - 1);
            }
        }

        return ans;
    }
}
