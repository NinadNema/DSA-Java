package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[] num =new int[5];
        for (int i = 0; i < num.length; i++) {
            num[i]=kb.nextInt();
        }

        System.out.println(Arrays.toString(num));

    }
}
