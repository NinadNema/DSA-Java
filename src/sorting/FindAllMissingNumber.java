package sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumber {
    public static void main(String[] args) {
        int[] arr= {4,3,2,7,8,2,3,1};

        System.out.println(findDisappearedNumbers(arr));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        int i = 0;
        while(i < nums.length){
            int cor = nums[i] - 1;
            if (nums[i] != nums[cor]) {
                int temp = nums[i];
                nums[i] = nums[cor];
                nums[cor] = temp;
            } else {
                i++;
            }
        }

        ArrayList<Integer> list = new ArrayList<>(10);
        for (int j = 0; j < nums.length; j++) {
            if((nums[j]-1) != j){
                list.add(j+1);
            }
        }
        return list;
    }
}
