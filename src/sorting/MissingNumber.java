package sorting;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr= {4,3,2,7,8,2,3,1};

        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] nums){
        int i =0;
        while (i < nums.length){
            int cor= nums[i];
            if(nums[i] >= nums.length){
                i++;
            }
            else {
                if (nums[i] != nums[cor]) {
                    int temp = nums[i];
                    nums[i] = nums[cor];
                    nums[cor] = temp;
                } else {
                    i++;
                }
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
}
