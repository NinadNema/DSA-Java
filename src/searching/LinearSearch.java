package searching;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[] num = {5, 8, 2, 9, 1};
        int target = kb.nextInt();
        System.out.println(linearSearch(num,target));
    }

    static int linearSearch(int[] arr, int target){
        if(arr.length == 0){
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }
}