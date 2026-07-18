package recursion;

public class ArraySorted {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,5};

        System.out.println(is_sorted(nums, 0));
    }

    static boolean is_sorted(int[] nums, int i){
        if(i == nums.length - 1){
            return true;
        }

        return nums[i] <= nums[i+1] && is_sorted(nums, i+1);
    }
}
