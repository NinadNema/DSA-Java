package arrays;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7,8};
        swap(arr,1,5);
        System.out.println(Arrays.toString(reverse(arr)));
    }

    static int[] reverse(int[] num) {
        int start = 0;
        int end = num.length-1;
        while (start<end) {
            swap(num, start, end);
            start++;
            end--;
        }
        return num;
    }


    static void swap(int[] num, int index1 , int index2) {
        if(index1 < 0 || index2 >= num.length) {
            System.out.println("Index Out of Bounds");
        } else {
            int tmp = num[index1];
            num[index1] = num[index2];
            num[index2] = tmp;

            System.out.println(Arrays.toString(num));
        }
    }
}
