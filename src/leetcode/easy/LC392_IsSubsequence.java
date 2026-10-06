package leetcode.easy;

public class LC392_IsSubsequence {
    public static void main(String[] args) {
        LC392_IsSubsequence lc = new LC392_IsSubsequence();

        String s = "abc";
        String t = "ahbgdc";

        System.out.println(lc.isSubsequence(s, t));
    }

//  Time Complexity - O(n)
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }

        return i == s.length();
    }
}
