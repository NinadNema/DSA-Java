package leetcode.easy;

public class LC3718_SmallestMissingMultipleK {
    public static void main(String[] args) {
        LC3718_SmallestMissingMultipleK lc = new LC3718_SmallestMissingMultipleK();

        int[] arr = {8,2,3,4,6};

        System.out.println(lc.missingMultiple(arr, 2));
    }

//  Time Complexity - O(n * k)
    public int missingMultiple(int[] nums, int k) {
        for (int i = k; ; i += k) {
            boolean found = false;

            for(int num : nums){
                if(num == i){
                    found = true;
                    break;
                }
            }

            if(!found){
                return i;
            }
        }
    }
}
