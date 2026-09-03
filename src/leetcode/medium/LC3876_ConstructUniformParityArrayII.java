package leetcode.medium;

public class LC3876_ConstructUniformParityArrayII {
    public static void main(String[] args) {
        LC3876_ConstructUniformParityArrayII lc = new LC3876_ConstructUniformParityArrayII();

        int[] nums = {1, 4, 7};
        System.out.println(lc.uniformArray(nums));
    }

//  Time Complexity - O(n)
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        boolean hasOdd = false;

        for (int num : nums1) {
            min = Math.min(min, num);

            if (num % 2 == 1) {
                hasOdd = true;
            }
        }

        return !(min % 2 == 0 && hasOdd);
    }
}
