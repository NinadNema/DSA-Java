package leetcode.medium;
import java.util.Arrays;

public class LC3302_FindLexicographicallySmallestValidSequence {
    static void main() {
        LC3302_FindLexicographicallySmallestValidSequence lc = new LC3302_FindLexicographicallySmallestValidSequence();

        String word1 = "vbcca";
        String word2 = "abc";

        System.out.println(Arrays.toString(lc.validSequence(word1, word2)));
    }

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] suf = new int[n + 1];
        Arrays.fill(suf, m);

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        int idx = 0;
        boolean used = false;

        for (int i = 0; i < n && idx < m; i++) {

            if (word1.charAt(i) == word2.charAt(idx)) {
                ans[idx++] = i;
            } else if (!used) {

                if (suf[i + 1] <= idx + 1) {
                    used = true;
                    ans[idx++] = i;
                }
            }
        }

        if (idx == m)
            return ans;

        return new int[0];
    }
}
