package leetcode.medium;

import java.util.Arrays;

public class LC3016_MinimumNumberPushesTypeWordII {
    public static void main(String[] args) {
        String s = "avghdcyinjmbopwtrfslzkuxeq";

        System.out.println(minimumPushes(s));
    }

//    Time Complexity - O(N)
    static int minimumPushes(String word){
        int[] freq = new int[26];

        for(char ch : word.toCharArray()){
            freq[ch - 'a'] ++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int idx = 0;

        for (int i = 25; i >= 0; i--) {
            if(freq[i] == 0) break;

            ans += freq[i] * (idx / 8 + 1);
            idx++;
        }

        return ans;
    }
}
