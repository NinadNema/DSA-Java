package leetcode.medium;

public class LC2904_ShortestAndLexicographicallySmallestBeautifulString {
    public static void main(String[] args) {
        LC2904_ShortestAndLexicographicallySmallestBeautifulString lc = new LC2904_ShortestAndLexicographicallySmallestBeautifulString();
        String s = "100011001";

        System.out.println(lc.shortestBeautifulSubstring(s, 3));
    }

//  Time Complexity - O(n)
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;

        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            if (ones == k) {

                while (s.charAt(left) == '0') {
                    left++;
                }

                String current = s.substring(left, right + 1);

                if (ans.isEmpty()
                        || current.length() < ans.length()
                        || (current.length() == ans.length()
                        && current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}
