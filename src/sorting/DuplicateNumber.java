package sorting;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1) {
                int cor = nums[i]-1;
                if (nums[i] != nums[cor]) {
                    int temp = nums[i];
                    nums[i] = nums[cor];
                    nums[cor] = temp;
                } else {
                    return nums[i];
                }
            }
            else{
                i++;
            }
        }
        return -1;
    }
}
