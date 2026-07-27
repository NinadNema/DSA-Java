package leetcode.easy;

public class LC1464_MaximumProductTwoElementsArray {
    public static void main(String[] args) {
        int[] arr = {10,2,5,2};

        System.out.println(maxProduct(arr));
    }
//  Time Complexity - O(N)
    static int maxProduct(int[] nums){
        int max1 = 0;
        int max2 = 0;
        for(int num : nums){
           if(num > max1){
               max2 = max1;
               max1 = num;
           }else if(num > max2){
               max2 = num;
           }
        }
       return (max1 - 1) * (max2 - 1);
    }
}
