package searching;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println(searchInsert(arr, 4));
    }

    static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
