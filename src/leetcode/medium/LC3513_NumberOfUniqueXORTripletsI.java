package leetcode.medium;

public class LC3513_NumberOfUniqueXORTripletsI {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};

        System.out.println(uniqueXorTriplets(arr));
    }

    static int uniqueXorTriplets(int[] nums){
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        int count = 0;
        while(n > 0){
            count++;
            n = n >> 1;
        }

        return (int) Math.pow(2, count);
    }
}
