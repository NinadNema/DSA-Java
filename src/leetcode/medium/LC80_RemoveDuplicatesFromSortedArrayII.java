package leetcode.medium;

public class LC80_RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        LC80_RemoveDuplicatesFromSortedArrayII lc = new LC80_RemoveDuplicatesFromSortedArrayII();

        int[] nums = {1,1,1,2,2,3};

        System.out.println(lc.removeDuplicates(nums));
    }

//  Time Complexity - O(n)
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }

        int l = 2;

        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[l - 2]){
                nums[l] = nums[i];
                l++;
            }
        }

        return l;
    }
}
