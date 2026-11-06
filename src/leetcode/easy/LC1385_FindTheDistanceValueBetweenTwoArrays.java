package leetcode.easy;

public class LC1385_FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        LC1385_FindTheDistanceValueBetweenTwoArrays lc = new LC1385_FindTheDistanceValueBetweenTwoArrays();

        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        int d = 2;

        System.out.println(lc.findTheDistanceValue(arr1, arr2, d));
    }

//  Time Complexity - O(n x m)
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        for (int x : arr1) {

            boolean valid = true;

            for (int y : arr2) {

                if (Math.abs(x - y) <= d) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}
