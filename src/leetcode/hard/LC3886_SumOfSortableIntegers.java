package leetcode.hard;

public class LC3886_SumOfSortableIntegers {
    public static void main(String[] args) {
        LC3886_SumOfSortableIntegers lc = new LC3886_SumOfSortableIntegers();

        int[] nums = {3,1,2};

        System.out.println(lc.sortableIntegers(nums));
    }

//  Time Complexity - O(n log n)
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        int[] suffMin = new int[n + 1];
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        int[] prefDrop = new int[n];

        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1];

            if (nums[i - 1] > nums[i]) {
                prefDrop[i]++;
            }
        }

        int ans = 0;

        for (int i = 1; i <= n / i; i++) {
            if (n % i == 0) {
                if (check(nums, i, prefMax, suffMin, prefDrop)) {
                    ans += i;
                }
                int other = n / i;
                if (other != i &&
                        check(nums, other, prefMax, suffMin, prefDrop)) {
                    ans += other;
                }
            }
        }

        return ans;
    }

    private boolean check(int[] nums, int k, int[] prefMax, int[] suffMin, int[] prefDrop) {
        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;
            int drops = prefDrop[end] - prefDrop[start];
            if (nums[end] > nums[start]) {
                drops++;
            }
            if (drops > 1) {
                return false;
            }
            if (prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}
