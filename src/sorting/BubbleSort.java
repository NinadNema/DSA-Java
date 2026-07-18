package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] num){
        boolean swapped;
        for (int i = 0; i < num.length; i++) {
            swapped = false;
            for (int j = 1; j < num.length-i; j++) {
                if(num[j] < num[j-1]){
                    int temp = num[j];
                    num[j] = num[j-1];
                    num[j-1] = temp;
                    swapped= true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
