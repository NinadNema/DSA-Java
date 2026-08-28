package leetcode.hard;

public class LC3734_LexicographicallySmallestPalindromicPermutationGreaterThanTarget {
    public static void main(String[] args) {
        LC3734_LexicographicallySmallestPalindromicPermutationGreaterThanTarget lc = new LC3734_LexicographicallySmallestPalindromicPermutationGreaterThanTarget();
        String s  = "baba";
        String tar = "abba";

        System.out.println(lc.lexPalindromicPermutation(s, tar));
    }

//  Time Complexity - O(n^2 + 26n)
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int half = n / 2;

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {

            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int[] remaining = halfFreq.clone();
        char[] firstHalf = new char[half];

        boolean possible = true;

        for (int i = 0; i < half; i++) {

            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            firstHalf[i] = target.charAt(i);
            remaining[c]--;
        }

        if (possible) {

            String candidate = buildPalindrome(firstHalf, middle);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        for (int pivot = half - 1; pivot >= 0; pivot--) {

            int[] rem = halfFreq.clone();

            boolean prefixPossible = true;

            for (int i = 0; i < pivot; i++) {

                int c = target.charAt(i) - 'a';

                if (rem[c] == 0) {
                    prefixPossible = false;
                    break;
                }

                rem[c]--;
            }

            if (!prefixPossible) {
                continue;
            }

            int current = target.charAt(pivot) - 'a';

            for (int bigger = current + 1; bigger < 26; bigger++) {

                if (rem[bigger] > 0) {

                    char[] newHalf = new char[half];

                    for (int i = 0; i < pivot; i++) {
                        newHalf[i] = target.charAt(i);
                    }

                    newHalf[pivot] = (char) ('a' + bigger);
                    rem[bigger]--;

                    int index = pivot + 1;

                    for (int c = 0; c < 26; c++) {

                        while (rem[c] > 0) {
                            newHalf[index++] = (char) ('a' + c);
                            rem[c]--;
                        }
                    }

                    return buildPalindrome(newHalf, middle);
                }
            }
        }

        return "";
    }

    private String buildPalindrome(char[] half, char middle) {

        StringBuilder result = new StringBuilder();

        for (char ch : half) {
            result.append(ch);
        }

        if (middle != 0) {
            result.append(middle);
        }

        for (int i = half.length - 1; i >= 0; i--) {
            result.append(half[i]);
        }

        return result.toString();
    }
}
