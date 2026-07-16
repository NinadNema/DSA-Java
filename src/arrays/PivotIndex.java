package arrays;

public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        System.out.println(pivotIndex(arr));
    }

    static int pivotIndex(int[] num){
        int right_sum = 0;
        int left_sum = 0;
        for (int j : num) {
            right_sum += j;
        }

        for (int i = 0; i < num.length; i++) {
            right_sum -= num[i];
            if (left_sum == right_sum){
                return i;
            }
            left_sum += num[i];
        }
        return -1;
    }
}
