package leetcode.hard;

import java.util.Arrays;

public class LC3505_MinimumOperationsToMakeElementsWithinKSubarraysEqual {
    public static void main(String[] args) {
        LC3505_MinimumOperationsToMakeElementsWithinKSubarraysEqual lc = new LC3505_MinimumOperationsToMakeElementsWithinKSubarraysEqual();

        int[] nums = {5,-2,1,3,7,3,6,4,-1};
        int x = 3;
        int k = 2;

        System.out.println(lc.minOperations(nums, x, k));
    }

    int m;
    int[] cnt;
    long[] sm;

    void upd(int i, int c, long s) {
        for (; i <= m; i += i & -i) {
            cnt[i] += c;
            sm[i] += s;
        }
    }

//  Time Complexity - O(n log n + n·k)
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] vals = Arrays.stream(nums).distinct().sorted().toArray();
        m = vals.length;
        cnt = new int[m + 1];
        sm = new long[m + 1];

        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = Arrays.binarySearch(vals, nums[i]) + 1;
        }

        int topBit = Integer.highestOneBit(m);
        int W = n - x + 1;
        long[] cost = new long[W];
        long total = 0;

        for (int i = 0; i < n; i++) {
            upd(id[i], 1, nums[i]);
            total += nums[i];
            if (i >= x) {
                upd(id[i - x], -1, -nums[i - x]);
                total -= nums[i - x];
            }
            if (i >= x - 1) {
                int need = (x + 1) / 2;
                int pos = 0;
                for (int p = topBit; p > 0; p >>= 1) {
                    int np = pos + p;
                    if (np <= m && cnt[np] < need) {
                        pos = np;
                        need -= cnt[np];
                    }
                }
                pos++;
                long med = vals[pos - 1];

                long c = 0, s = 0;
                for (int j = pos; j > 0; j -= j & -j) {
                    c += cnt[j];
                    s += sm[j];
                }
                cost[i - x + 1] = med * c - s + (total - s) - med * (x - c);
            }
        }

        final long INF = Long.MAX_VALUE / 4;
        long[] prev = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            long[] cur = new long[n + 1];
            Arrays.fill(cur, INF);
            for (int i = j * x; i <= n; i++) {
                long best = cur[i - 1];
                long cand = prev[i - x] + cost[i - x];
                cur[i] = Math.min(best, cand);
            }
            prev = cur;
        }
        return prev[n];
    }
}
