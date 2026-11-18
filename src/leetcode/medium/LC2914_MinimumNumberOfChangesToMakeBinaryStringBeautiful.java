package leetcode.medium;

public class LC2914_MinimumNumberOfChangesToMakeBinaryStringBeautiful {
    public static void main(String[] args) {
        LC2914_MinimumNumberOfChangesToMakeBinaryStringBeautiful lc = new LC2914_MinimumNumberOfChangesToMakeBinaryStringBeautiful();

        String s = "1001";

        System.out.println(lc.minChanges(s));
    }

//  Time Complexity - O(n)
    public int minChanges(String s) {
        int changes = 0;

        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }
}
