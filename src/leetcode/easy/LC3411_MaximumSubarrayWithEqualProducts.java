package leetcode.easy;

public class LC3411_MaximumSubarrayWithEqualProducts {
    public static void main(String[] args) {
        LC3411_MaximumSubarrayWithEqualProducts lc = new LC3411_MaximumSubarrayWithEqualProducts();

        int[] nums = new int[]{1, 2, 1, 2, 1, 1, 1};

        System.out.println(lc.maxLength(nums));
    }

//  Time Complexity - O(n²)
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            long product = 1;
            long gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);

                if (product == gcd * lcm) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
