package recursion;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 18, 9};

        System.out.println(linear_search(nums, 10, 0));
    }

    static int linear_search(int[] nums, int tar, int i){
        if(i == nums.length){
            return -1;
        }
        if(nums[i] == tar){
            return i;
        }
        return linear_search(nums, tar, i + 1);
    }
}
