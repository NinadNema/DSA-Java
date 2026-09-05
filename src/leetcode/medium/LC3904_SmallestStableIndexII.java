package leetcode.medium;

public class LC3904_SmallestStableIndexII {
    public static void main(String[] args) {
        LC3904_SmallestStableIndexII lc = new LC3904_SmallestStableIndexII();

        int[] nums = {5,0,1,4};

        int k = 3;
        System.out.println(lc.firstStableIndex(nums, k));
    }

    public int firstStableIndex(int[] nums, int k){
        int n = nums.length;

        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = nums[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            int sum = prefixMax - suffixMin[i];

            if(sum <= k){
                return i;
            }
        }

        return -1;
    }
}
