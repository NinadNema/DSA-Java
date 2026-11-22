package leetcode.easy;

public class LC2124_CheckIfAllAAppearsBeforeAllB {
    public static void main(String[] args) {
        LC2124_CheckIfAllAAppearsBeforeAllB lc = new LC2124_CheckIfAllAAppearsBeforeAllB();

        String s = "aaabbb";

        System.out.println(lc.checkString(s));
    }

//  Time Complexity - O(n)
    public boolean checkString(String s) {
        boolean seenB = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                seenB = true;
            } else {
                if (seenB) {
                    return false;
                }
            }
        }

        return true;
    }
}
