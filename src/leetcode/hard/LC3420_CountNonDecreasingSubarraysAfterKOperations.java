package leetcode.hard;

public class LC3420_CountNonDecreasingSubarraysAfterKOperations {
    public static void main(String[] args) {
        LC3420_CountNonDecreasingSubarraysAfterKOperations lc = new LC3420_CountNonDecreasingSubarraysAfterKOperations();

        int[] nums = new int[]{6, 3, 1, 2, 4, 4};
        int k = 7;

        System.out.println(lc.countNonDecreasingSubarrays(nums, k));
    }

//  Time Complexity - O(n log n)
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];

        int[] nxt = new int[n + 1];
        nxt[n] = n;
        int[] st = new int[n];
        int top = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (top > 0 && nums[st[top - 1]] <= nums[i]) top--;
            nxt[i] = top == 0 ? n : st[top - 1];
            st[top++] = i;
        }

        int LOG = 1;
        while ((1 << LOG) <= n) LOG++;
        int[][] up = new int[LOG][n + 1];
        long[][] cst = new long[LOG][n + 1];
        for (int i = 0; i <= n; i++) {
            up[0][i] = nxt[i];
            cst[0][i] = i == n ? 0
                    : (long) nums[i] * (nxt[i] - i) - (pre[nxt[i]] - pre[i]);
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i <= n; i++) {
                int mid = up[j - 1][i];
                up[j][i] = up[j - 1][mid];
                cst[j][i] = cst[j - 1][i] + cst[j - 1][mid];
            }
        }

        long ans = 0;
        for (int l = 0; l < n; l++) {
            int cur = l;
            long used = 0;
            for (int j = LOG - 1; j >= 0; j--) {
                int to = up[j][cur];
                if (used + cst[j][cur] <= k) {
                    used += cst[j][cur];
                    cur = to;
                }
            }
            int end;
            if (cur == n) {
                end = n;
            } else {
                long rem = k - used;
                int lo = cur + 1, hi = nxt[cur] - 1;
                int best = cur;
                while (lo <= hi) {
                    int m = (lo + hi) >>> 1;
                    long c = (long) nums[cur] * (m - cur + 1) - (pre[m + 1] - pre[cur]);
                    if (c <= rem) { best = m; lo = m + 1; } else hi = m - 1;
                }
                end = best + 1;
            }
            ans += end - l;
        }
        return ans;
    }
}
