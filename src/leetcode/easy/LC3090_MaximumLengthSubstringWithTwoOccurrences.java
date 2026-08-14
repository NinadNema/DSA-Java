package leetcode.easy;

public class LC3090_MaximumLengthSubstringWithTwoOccurrences {
    public static  void main(String[] args){
        LC3090_MaximumLengthSubstringWithTwoOccurrences lc = new LC3090_MaximumLengthSubstringWithTwoOccurrences();
        String s = "bcbbbcba";
        System.out.println(lc.maximumLengthSubstring(s));
    }

    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'a';
            freq[index]++;

            while(freq[index] > 2){
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
