package sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,1,4,2,3};

        System.out.println(Arrays.toString(sort(arr)));
    }

    static int[] sort(int[] num){
        int i = 0;
        while(i < num.length){
            int correct = num[i]-1;
            if(num[i] != num[correct]){
                int temp = num[i];
                num[i] = num[correct];
                num[correct] = temp;
            }
            else{
                i++;
            }
        }
        return num;
    }
}
