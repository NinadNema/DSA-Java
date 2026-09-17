package leetcode.medium;

import java.util.Arrays;

public class LC1477_FindTwoNonOverlappingSubArraysEachWithTargetSum {
    public static void main(String[] args) {
        LC1477_FindTwoNonOverlappingSubArraysEachWithTargetSum lc = new LC1477_FindTwoNonOverlappingSubArraysEachWithTargetSum();

        int[] arr = {4,3,2,6,2,3,4};
        int target = 6;

        System.out.println(lc.minSumOfLengths(arr, target));
    }

//  Time Complexity - O(n)
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE;

        int[] best = new int[n];

        Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int answer = INF;
        int minLength = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int length = right - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                            answer,
                            length + best[left - 1]
                    );
                }

                minLength = Math.min(minLength, length);
            }

            if (right == 0) {
                best[right] = minLength;
            } else {
                best[right] = Math.min(best[right - 1], minLength);
            }
        }

        return answer == INF ? -1 : answer;
    }
}
