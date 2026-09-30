package leetcode.easy;

public class LC125_ValidPalindrome {
    public static void main(String[] args) {
        LC125_ValidPalindrome lc = new LC125_ValidPalindrome();

        String s = "A man, a plan, a canal: Panama";

        System.out.println(lc.isPalindrome(s));
    }

//  Time Complexity - O(n)
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        s = s.toLowerCase();

        while(l < r){
            if(Character.isLetterOrDigit(s.charAt(l))){
                if(Character.isLetterOrDigit(s.charAt(r))){
                    if(s.charAt(l) == s.charAt(r)){
                        l++;
                        r--;
                    }else{
                        return false;
                    }
                }else{
                    r--;
                }
            }else{
                l++;
            }
        }

        return true;
    }
}
