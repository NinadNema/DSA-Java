package string;

public class Palindrome {
    public static void main(String[] args) {
        String str = "naman";
        System.out.println(isPalindrome(str));
    }


    static Boolean isPalindrome(String str){
        if (str == null || str.isEmpty()){
            return true;
        }
        str = str.trim();
        str = str.toLowerCase();

        int start = 0;
        int end = str.length()-1;

        while(start < end){

            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
