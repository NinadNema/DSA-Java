package numbersystem;

import java.util.Arrays;

public class GCDPairSum {
    public static void main(String[] args) {
        int[] arr = {3,5,6};

        System.out.println(gcdSum(arr));
    }

    static long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
            int gcd_prefix = gcd(nums[i], max);
            prefixGcd[i] = gcd_prefix;
        }
        Arrays.sort(prefixGcd);
        int s = 0;
        int e = prefixGcd.length - 1;
        long sum_gcd = 0;
        while(s < e){
            sum_gcd += gcd(prefixGcd[s], prefixGcd[e]);
            s++;
            e--;
        }
        return sum_gcd;
    }

    static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
