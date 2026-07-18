package sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        List<Integer> list = new ArrayList<>(10);
        while(i < nums.length){
            int cor = nums[i]-1;
            if (nums[i] != nums[cor]) {
                int temp = nums[i];
                nums[i] = nums[cor];
                nums[cor] = temp;
            }
            else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }
}
