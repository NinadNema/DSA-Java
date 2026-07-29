package leetcode.easy;

public class LC190_ReverseBits {
    public static void main(String[] args) {
        int n = 43261596;
        System.out.println(reverseBits(n));
    }

//    Time Complexity - O(32) - O(1)
    static int reverseBits(int n){
        int digit = 0;
        for(int i = 0; i < 32; i++){
            digit <<= 1;
            digit |= (n & 1);
            n >>= 1;
        }

        return digit;
    }
}
