package bitmanipulation;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,1,2,1,3,6,4};
        System.out.println(bruteForce(arr));
        System.out.println(usingXOR(arr));
    }
    //brute force
    static int bruteForce(int[] nums){
        int index = 0;
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return index;
    }

    //Optimal
    static int usingXOR(int[] nums){
        int unique = 0;
        for(int i : nums){
            unique = unique ^ i;
        }
        return unique;
    }
}