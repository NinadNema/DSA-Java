package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2,3,1,4,7,6,5};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] num){
        for (int i = 0; i < num.length; i++) {
            int last = num.length-i-1;
            int max = 0;
            for (int j = 0; j <= last; j++) {
                if(num[j] > num[max]){
                    max = j;
                }
            }
            int temp = num[max];
            num[max] = num[last];
            num[last] = temp;
        }
    }
}
