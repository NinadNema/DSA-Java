package searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};

        System.out.println(ascending_search(arr , 9));
        System.out.println(decending_search(arr,2));
        System.out.println(asc_dec(arr, 5));
    }

    static int asc_dec(int[] num, int target){
        int start = num[0];
        int end = num[num.length-1];

        if (start <end){
            return ascending_search(num ,target);
        }
        else {
            return decending_search(num ,target);
        }
    }

    static int ascending_search(int[] num, int target){
        int start = 0;
        int end = num.length-1;

        while (start <= end)
        {
//            int mid = (start + end)/2; //if start and end value are large then ot will excced int range
            int mid = start + (end-start)/2; //Better way to find mid
            if(num[mid] < target){
                start = mid + 1;
            }
            else if(num[mid] > target){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    static int decending_search(int[] num, int target){
        int start = 0;
        int end = num.length-1;

        while (start <= end)
        {
//            int mid = (start + end)/2; //if start and end value are large then ot will excced int range
            int mid = start + (end-start)/2; //Better way to find mid
            if(num[mid] < target){
                end = mid-1;
            }
            else if(num[mid] > target){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
