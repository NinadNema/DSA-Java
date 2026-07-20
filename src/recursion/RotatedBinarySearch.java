package recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5,6,7,1,2,3,4};
        int s = 0;
        int e = nums.length - 1;

        System.out.println(rotatedBinarySearch(nums, 2, s, e));
    }

    static int rotatedBinarySearch(int[] nums, int target, int s, int e){
        while(s <= e){
            if(s > e){
                return -1;
            }
            int mid = s + (e - s) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[s] <= nums[mid]){
                if(nums[mid] >= target && nums[s] <= target){
                    return rotatedBinarySearch(nums, target, s, mid - 1);
                }else{
                    return rotatedBinarySearch(nums, target, mid + 1, e);
                }
            }else{
                if(nums[mid] <= target && nums[e] >= target){
                    return rotatedBinarySearch(nums, target, mid + 1, e);
                }else{
                    return rotatedBinarySearch(nums, target, s,  mid - 1);
                }
            }
        }
        return -1;
    }
}
