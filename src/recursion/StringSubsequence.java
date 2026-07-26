package recursion;

import java.util.ArrayList;

public class StringSubsequence {
    public static void main(String[] args) {
        String s = "abc";

        subseq("",s);
        System.out.println(subseqAL("", s));
        subseqACSII("", s);
    }

//  Subsequence
    static void subseq(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

//    Return a Arraylist of subsequence
    static ArrayList<String> subseqAL(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        ArrayList<String> left = subseqAL(p + ch, up.substring(1));
        ArrayList<String> right = subseqAL(p, up.substring(1));
        left.addAll(right);

        return left;
    }

//    Sebsequence withACSII Values
    static void subseqACSII(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseqACSII(p + ch, up.substring(1));
        subseqACSII(p, up.substring(1));
        subseqACSII(p + (int) ch, up.substring(1));
    }
}
