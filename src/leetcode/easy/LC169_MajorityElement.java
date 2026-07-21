package leetcode.easy;

public class LC169_MajorityElement {
    public static void main(String[] args) {
        int[] arr = {8, 7, 8,7,8, 7, 8};

        System.out.println(majorityElement(arr));
        System.out.println(mooreVoting(arr));
    }
//    Brute Force
    static int majorityElement(int[] nums){
        int i = 0;

        while(i < nums.length){
            int candidate = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == candidate){
                    count++;
                }
            }
            if(count > nums.length / 2){
                return candidate;
            }else{
                i++;
            }
        }
        return -1;
    }

//    Moore's Voting Algorithm
    static int mooreVoting(int[] nums){
        int candidate = 0;
        int count= 0;

        for(int num: nums){
            if(count == 0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        return candidate;
    }
}
