package leetcode.hard;

import java.util.*;

public class LC3414_MaximumScoreOfNonOverlappingIntervals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LC3414_MaximumScoreOfNonOverlappingIntervals lc = new LC3414_MaximumScoreOfNonOverlappingIntervals();

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                int n = sc.nextInt();
                a.add(n);
            }
            list.add(a);
        }

        System.out.println(Arrays.toString(lc.maximumWeight(list)));
    }

    static class State {
        long score;
        int[] indices;

        State(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

//  Time Complexity - O(n log n)
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();

        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = findNext(arr, i);
        }

        State[][] dp = new State[n + 1][5];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new int[0]);
        }

        for (int k = 1; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                State skip = dp[i + 1][k];

                State takeNext = dp[next[i]][k - 1];

                int[] takeIndices = new int[takeNext.indices.length + 1];

                takeIndices[0] = arr[i][3];

                System.arraycopy(takeNext.indices, 0, takeIndices, 1, takeNext.indices.length);

                Arrays.sort(takeIndices);

                State take = new State(arr[i][2] + takeNext.score, takeIndices);

                dp[i][k] = better(skip, take);
            }
        }

        return dp[0][4].indices;
    }

    private int findNext(int[][] arr, int i) {

        int target = arr[i][1];

        int left = i + 1;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private State better(State a, State b) {

        if (a.score > b.score) {
            return a;
        }

        if (b.score > a.score) {
            return b;
        }

        if (compare(a.indices, b.indices) <= 0) {
            return a;
        }

        return b;
    }

    private int compare(int[] a, int[] b) {

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}
