package arrays;

public class RichestPerson {
    public static void main(String[] args) {
        int[][] arr = {
                {2,8,7},
                {7,1,3},
                {1,9,5}
        };

        System.out.println(maximumWealth(arr));
    }

    static int maximumWealth(int[][] accounts){
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
