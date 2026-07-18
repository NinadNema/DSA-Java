package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(binarysearch(arr, 3, 0 , arr.length-1));
    }

    static int binarysearch(int[] nums,int tar, int s, int e){
        int mid = s+(e-s)/2;

        if(s>e){
            return -1;
        }
        if(nums[mid] == tar){
            return mid;
        } else if (nums[mid] > tar) {
            return binarysearch(nums, tar, s,mid - 1);
        }
        else {
            return binarysearch(nums, tar,mid + 1,e);
        }
    }
}
