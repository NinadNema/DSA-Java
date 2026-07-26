package recursion;

public class SkipACharacter {
    public static void main(String[] args) {
        String s = "baccad";

        skipchar(s, "");
        System.out.println(skip(s));
    }
//  Approach 1
    static void skipchar(String s, String res){
        if(s.isEmpty()){
            System.out.println(res);
            return;
        }

        char ch = s.charAt(0);

        if(ch == 'a'){
            skipchar(s.substring(1), res);
        }else{
            skipchar(s.substring(1), res + ch);
        }
    }

//    Approach 2
    static String skip(String s){
        if(s.isEmpty()){
            return "";
        }

        char ch = s.charAt(0);

        if(ch == 'a'){
            return skip(s.substring(1));
        }else{
            return ch + skip(s.substring(1));
        }
    }
}
