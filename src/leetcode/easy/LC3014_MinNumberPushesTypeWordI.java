package leetcode.easy;

public class LC3014_MinNumberPushesTypeWordI {
    public static void main(String[] args) {
        String s = "abcde";

        System.out.println(minimumPushes(s));
    }

//    Time Complexity - O(n)
    static int minimumPushes(String word) {
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            ans += (i/8) + 1;
        }

        return ans;
    }
}
