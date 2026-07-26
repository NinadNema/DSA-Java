package recursion;

public class SkipAString {
    public static void main(String[] args) {
        String s = "thisisapplegood";

        System.out.println(skip(s));
        System.out.println(skipapp(s));
    }
//  Skip a String
    static String skip(String s){
        if(s.isEmpty()){
            return "";
        }

        if(s.startsWith("apple")){
            return skip(s.substring(5));
        }else{
            return s.charAt(0) + skip(s.substring(1));
        }
    }

//    Skip String unless it's another required string
    static String skipapp(String s){
        if(s.isEmpty()){
            return  "";
        }

        if(s.startsWith("app") && !s.startsWith("apple")){
            return skipapp(s.substring(3));
        }else{
            return s.charAt(0) + skipapp(s.substring(1));
        }
    }
}
