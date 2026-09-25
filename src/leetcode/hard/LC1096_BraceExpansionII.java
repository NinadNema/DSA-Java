package leetcode.hard;

import java.util.*;

public class LC1096_BraceExpansionII {
    public static void main(String[] args) {
        LC1096_BraceExpansionII lc = new LC1096_BraceExpansionII();

        String s = "{a,b}{c,{d,e}}";
        System.out.println(lc.braceExpansionII(s));
    }

    int index = 0;

//  Time Complexity - O(n + W × L × number of combinations)
    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);

        List<String> result = new ArrayList<>(set);
        Collections.sort(result);

        return result;
    }

    private Set<String> parse(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {

            if (s.charAt(index) == ',') {

                result.addAll(current);
                current.clear();
                current.add("");

                index++;
            }
            else {

                Set<String> next;

                if (s.charAt(index) == '{') {
                    index++;
                    next = parse(s);
                    index++;
                }
                else {
                    next = new HashSet<>();
                    next.add(String.valueOf(s.charAt(index)));
                    index++;
                }

                current = combine(current, next);
            }
        }

        result.addAll(current);

        return result;
    }

    private Set<String> combine(Set<String> first, Set<String> second) {

        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}
