package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;

public class LC3720_LexicographicallySmallestPermutationGreaterThanTarget {
    public static void main(String[] args) {
        LC3720_LexicographicallySmallestPermutationGreaterThanTarget lc = new LC3720_LexicographicallySmallestPermutationGreaterThanTarget();
        String s = "ab";
        String tar = "ab";

        System.out.println(lc.lexGreaterPermutation(s, tar));
    }

//  Method 1: Using Frequency Count
//  Time Complexity - O(n)
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] total = new int[26];

        for (char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }

        int[] prefix = new int[26];

        for (int i = 0; i < n; i++) {
            int c = target.charAt(i) - 'a';

            prefix[c]++;

            if (prefix[c] > total[c]) {
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            int[] remaining = total.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int c = target.charAt(j) - 'a';

                if (remaining[c] == 0) {
                    possible = false;
                    break;
                }

                remaining[c]--;
            }

            if (!possible) {
                continue;
            }

            int current = target.charAt(i) - 'a';

            for (int bigger = current + 1; bigger < 26; bigger++) {

                if (remaining[bigger] > 0) {

                    StringBuilder ans = new StringBuilder();

                    ans.append(target, 0, i);
                    ans.append((char) ('a' + bigger));

                    remaining[bigger]--;

                    for (int c = 0; c < 26; c++) {
                        while (remaining[c] > 0) {
                            ans.append((char) ('a' + c));
                            remaining[c]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }



//  Method 2: Creating All Permutation and Then Checking
//  Time Complexity - O(n!)
    public String lexGreaterPermutation2(String s, String target) {
        ArrayList<String> list = permutation(s, "");
        Collections.sort(list);

        for(String str : list){
            if(str.compareTo(target) > 0){
                return str;
            }
        }

        return "";
    }

    public ArrayList<String> permutation(String up, String p){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);

        for (int i = 0; i < p.length() + 1; i++) {
            String p1 = p.substring(0, i);
            String p2 = p.substring(i, p.length());
            ans.addAll(permutation(up.substring(1), p1 + ch + p2));
        }

        return ans;
    }
}
