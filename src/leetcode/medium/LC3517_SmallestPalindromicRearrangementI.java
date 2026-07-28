package leetcode.medium;

public class LC3517_SmallestPalindromicRearrangementI {
    public static void main(String[] args) {
        String s = "z";

        System.out.println(smallestPalindrome(s));
    }

//    Time Complexity - O(n)
    static String smallestPalindrome(String s){
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {

            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) (i + 'a'));
            }

            if (freq[i] % 2 == 1) {
                middle = String.valueOf((char) (i + 'a'));
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + middle + right;
    }
}
