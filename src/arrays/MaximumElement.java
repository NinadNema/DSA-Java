package arrays;

public class MaximumElement {
    public static void main(String[] args) {
        int[] arr = {8,7,9,54,200,5,1,2};
        maxElement(arr,2,7);
        minElement(arr);
    }

    static void maxElement(int[] num, int index1, int index2){
        int max = num[index1];
        for(int i = index1; i < index2; i++){
            if (num[i] > max) {
                max = num[i];
            }
        }
        System.out.println(max);
    }

    static void minElement(int[] num){
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }
        System.out.println(min);
    }
}
