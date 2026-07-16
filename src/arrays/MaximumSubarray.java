package arrays;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {5,4,-1,7,8};

        System.out.println(maxSubarray(arr));
    }

    static int maxSubarray(int[] num){
        int max = Integer.MIN_VALUE;
        if(num.length == 1){
            max = num[0];
        }
        for (int i = 0; i < num.length; i++) {
            int sum = 0;
            for (int j = i; j < num.length ; j++) {
                sum = sum + num[j];
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}
