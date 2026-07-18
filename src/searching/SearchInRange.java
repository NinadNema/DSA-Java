package searching;

public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {1,3,4,24,243,15,84,65};
        System.out.println(linearsearch(arr, 243, 2, 5));
    }

    static int linearsearch(int[] num, int target, int index1, int index2){
        if(num.length == 0){
            return -1;
        }

        for (int i = index1; i <= index2; i++) {
            if(num[i] == target){
                return i;
            }
        }
        return -1;
    }
}
