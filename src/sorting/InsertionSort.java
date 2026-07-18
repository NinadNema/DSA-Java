package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {4,5,3,2,1};

        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] num){
        for (int i = 0; i <= num.length-2; i++) {
            for (int j = i+1; j > 0; j--) {
                if(num[j] < num[j-1]){
                    int temp = num[j];
                    num[j] = num[j-1];
                    num[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
        return num;
    }
}
