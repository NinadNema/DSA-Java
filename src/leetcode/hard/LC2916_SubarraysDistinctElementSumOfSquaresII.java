package leetcode.hard;

public class LC2916_SubarraysDistinctElementSumOfSquaresII {
    public static void main(String[] args) {
        LC2916_SubarraysDistinctElementSumOfSquaresII lc = new LC2916_SubarraysDistinctElementSumOfSquaresII();

        int[] nums = {1,2,1};

        System.out.println(lc.sumCounts(nums));
    }

    static final long MOD = 1_000_000_007L;

    long[] sum;
    long[] square;
    long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;

        sum = new long[4 * n];
        square = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = last[nums[i]];

            update(1, 0, n - 1, prev + 1, i);

            ans = (ans + square[1]) % MOD;

            last[nums[i]] = i;
        }

        return (int) ans;
    }

    private void update(int node, int start, int end, int left, int right) {

        if (left > end || right < start) {
            return;
        }

        if (left <= start && end <= right) {
            square[node] = (square[node] + 2 * sum[node] + (end - start + 1)) % MOD;

            sum[node] = (sum[node] + (end - start + 1)) % MOD;

            lazy[node]++;
            return;
        }

        push(node, start, end);

        int mid = start + (end - start) / 2;

        update(node * 2, start, mid, left, right);
        update(node * 2 + 1, mid + 1, end, left, right);

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        square[node] = (square[node * 2] + square[node * 2 + 1]) % MOD;
    }

    private void push(int node, int start, int end) {
        if (lazy[node] == 0 || start == end) {
            return;
        }

        int mid = start + (end - start) / 2;

        apply(node * 2, start, mid, lazy[node]);
        apply(node * 2 + 1, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    private void apply(int node, int start, int end, long value) {
        long len = end - start + 1;

        square[node] = (square[node] + 2 * value % MOD * sum[node] + value * value % MOD * len) % MOD;

        sum[node] = (sum[node] + value * len) % MOD;

        lazy[node] += value;
    }
}
