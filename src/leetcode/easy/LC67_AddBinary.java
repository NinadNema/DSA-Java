package leetcode.easy;

public class LC67_AddBinary {
    public static void main(String[] args) {
        LC67_AddBinary lc = new LC67_AddBinary();

        String a = "11";
        String b = "1";

        System.out.println(lc.addBinary(a, b));
    }

//  Time Complexity - O(n)
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while(i >= 0 || j >= 0 || carry != 0){
            int sum = carry;

            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }

            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}
