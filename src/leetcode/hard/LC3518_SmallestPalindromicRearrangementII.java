package leetcode.hard;

public class LC3518_SmallestPalindromicRearrangementII {
    public static void main(String[] args) {
        String s = "kxk";

        System.out.println(smallestPalindrome(s, 2));
    }

//    Time Complexity - O(n^2)
    static String smallestPalindrome(String s, int k){
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = '\0';

        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1)
                middle = (char)(i + 'a');

            freq[i] /= 2;
        }

        if (countWays(freq) < k) {
            return "";
        }

        int len = 0;

        for (int x : freq) {
            len += x;
        }


        for (int pos = 0; pos < len; pos++) {

            for (int ch = 0; ch < 26; ch++) {

                if (freq[ch] == 0)
                    continue;

                freq[ch]--;

                long ways = countWays(freq);

                if (ways >= k) {
                    left.append((char)(ch + 'a'));
                    break;
                }

                k -= ways;
                freq[ch]++;
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if (middle == '\0') {
            return left.toString() + right;
        }

        return left.toString() + middle + right;
    }

    static long countWays(int[] freq) {
        long ways = 1;
        int used = 0;

        for (int f : freq) {

            if (f == 0) continue;

            for (int i = 1; i <= f; i++) {
                ways = ways * (used + i) / i;

                if (ways > 1_000_000) {
                    ways = 1_000_001;
                }
            }

            used += f;
        }

        return ways;
    }
}
