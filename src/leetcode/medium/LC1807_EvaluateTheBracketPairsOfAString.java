package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC1807_EvaluateTheBracketPairsOfAString {
    public static void main(String[] args) {
        LC1807_EvaluateTheBracketPairsOfAString lc = new LC1807_EvaluateTheBracketPairsOfAString();

        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> list  = new ArrayList<>();
        List<String> list1  = new ArrayList<>();

        list.add("name");
        list.add("bob");

        list1.add("age");
        list1.add("two");

        knowledge.add(list);
        knowledge.add(list1);

        System.out.println(lc.evaluate(s, knowledge));
    }

//  Time Complexity - O(n + k)
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        int i = 0;
        StringBuilder ans = new StringBuilder();

        while(i < s.length()){
            if(s.charAt(i) == '('){
                i++;

                StringBuilder key = new StringBuilder();

                while(s.charAt(i) != ')'){
                    key.append(s.charAt(i));
                    i++;
                }

                String value = map.get(key.toString());

                if(value == null){
                    ans.append('?');
                }else{
                    ans.append(value);
                }

                i++;
            }else{
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }
}
