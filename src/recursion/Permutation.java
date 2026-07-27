package recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String s = "abc";

        permutation("", s);
        System.out.println(permutation2("", s));
        System.out.println(permutationCount("", s));
    }

//  Returning All Permutation
    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i < p.length()+1; i++){
            String p1 = p.substring(0, i);
            String p2 = p.substring(i, p.length());

            permutation(p1 + ch + p2, up.substring(1));
        }
    }

//  Returning All Permutation in ArrayList
    static ArrayList<String> permutation2(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i = 0; i < p.length()+1; i++){
            String p1 = p.substring(0, i);
            String p2 = p.substring(i, p.length());

             ans.addAll(permutation2(p1 + ch + p2, up.substring(1)));
        }
        return ans;
    }

//    Counting Number of Permutation
    static int permutationCount(String p, String up){
        if(up.isEmpty()){
            return 1;
        }
        char ch = up.charAt(0);

        ArrayList<String> ans = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < p.length()+1; i++){
            String p1 = p.substring(0, i);
            String p2 = p.substring(i, p.length());

            count = count + permutationCount(p1 + ch + p2, up.substring(1));
        }
        return count;
    }
}
