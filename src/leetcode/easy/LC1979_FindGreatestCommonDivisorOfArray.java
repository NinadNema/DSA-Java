package leetcode.easy;

public class LC1979_FindGreatestCommonDivisorOfArray {
    public static void main(String[] args) {
        int[] arr = {7,5,6,8,3};

        System.out.println(findGCD(arr));
    }

    static int findGCD(int[] nums){
        int min = nums[0];
        int max = nums[0];
        for(int i : nums){
            if(i > max){
                max = i;
            }
            if(i < min){
                min = i;
            }
        }

        return gcd(min, max);
    }

    static int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }
}
