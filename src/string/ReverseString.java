package string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] arr = {'h','e','l','l','o'};
        reverseString(arr);
    }

    static void reverseString(char[] s){
        int l = 0;
        int r = s.length - 1;
        while (l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }

        System.out.println(Arrays.toString(s));
    }
}
