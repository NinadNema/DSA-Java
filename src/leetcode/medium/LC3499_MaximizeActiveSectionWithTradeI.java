package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LC3499_MaximizeActiveSectionWithTradeI {
    public static void main(String[] args) {
        String s = "01010";

        System.out.println(maxActiveSectionsAfterTrade(s));
    }

    static int maxActiveSectionsAfterTrade(String s){
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        // Augment the string
        String t = "1" + s + "1";

        int n = t.length();

        // Store lengths of consecutive groups
        List<Character> chars = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        int i = 0;
        while (i < n) {
            char ch = t.charAt(i);
            int j = i;

            while (j < n && t.charAt(j) == ch) {
                j++;
            }

            chars.add(ch);
            len.add(j - i);

            i = j;
        }

        int maxGain = 0;

        // Look for 0 - 1 - 0 pattern
        for (i = 1; i < chars.size() - 1; i++) {

            if (chars.get(i) == '1'
                    && chars.get(i - 1) == '0'
                    && chars.get(i + 1) == '0') {

                int gain = len.get(i - 1) + len.get(i + 1);

                maxGain = Math.max(maxGain, gain);
            }
        }

        return ones + maxGain;
    }
}
