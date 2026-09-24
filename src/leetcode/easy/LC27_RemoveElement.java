package leetcode.easy;

public class LC27_RemoveElement {
    public static void main(String[] args) {
        LC27_RemoveElement lc = new LC27_RemoveElement();

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(lc.removeElement(nums, val));
    }

//  Time Complexity - O(n)
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int e = nums.length - 1;

        while(l < e){
            if(nums[l] == val){
                int temp = nums[l];
                nums[l] = nums[e];
                nums[e] = temp;
                e--;
            }else{
                l++;
            }
        }

        int k = 0;
        for (int num : nums) {
            if (num != val) {
                k++;
            }
        }

        return k;
    }
}
