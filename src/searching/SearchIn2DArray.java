package searching;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {2,4,5},
                {67,1},
                {30,54,14,89}
        };

        int target = 89;
        System.out.println(Arrays.toString(search(arr, target)));
    }

    static int[] search(int[][] num, int target){
        if(num.length == 0){
            return new int[] {-1};
        }

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num[i].length; j++) {
                if (num[i][j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1};
    }
}
