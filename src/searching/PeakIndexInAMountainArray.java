package searching;

public class PeakIndexInAMountainArray {
    public static void main(String[] args) {
        int[] num = {3,5,3,2,0};

        System.out.println(peakIndexInMountainArray(num));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int s = 0;
        int e = arr.length-1;

        while(s < e){
            int mid = s+(e-s)/2;

            if(arr[mid] < arr[mid + 1]){
                s = mid + 1;
            }else{
                e = mid;
            }
        }
        return s;
    }
}
