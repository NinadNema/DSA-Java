package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1520_MaximumNumberOfNonOverlappingSubstrings {
    public static void main(String[] args) {
        LC1520_MaximumNumberOfNonOverlappingSubstrings lc = new LC1520_MaximumNumberOfNonOverlappingSubstrings();

        String s = "adefaddaccc";

        System.out.println(lc.maxNumOfSubstrings(s));
    }

//  Time Complexity - O(n)
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';

            if (first[c] != i) {
                continue;
            }

            int left = i;
            int right = last[c];

            boolean valid = true;

            for (int j = left; j <= right; j++) {
                int current = s.charAt(j) - 'a';

                if (first[current] < left) {
                    valid = false;
                    break;
                }

                right = Math.max(right, last[current]);
            }

            if (valid) {
                intervals.add(new int[]{left, right});
            }
        }

        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));

        List<String> ans = new ArrayList<>();

        int lastEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > lastEnd) {
                ans.add(s.substring(start, end + 1));
                lastEnd = end;
            }
        }

        return ans;
    }
}
