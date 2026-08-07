package leetcode.easy;

public class LC26_RemoveDuplicatesfromSortedArray {
    static void main() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};

        System.out.println(removeDulicate(arr));
    }

//  Time Complexity - O(n)
    static int removeDulicate(int[] nums){
        int l = 0;
        int r = 1;

        while(r < nums.length){
            if(nums[l] == nums[r]){
                r++;
            }else{
                swap(nums, l + 1, r);
                l++;
                r++;
            }
        }

        return l + 1;
    }

    static void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
