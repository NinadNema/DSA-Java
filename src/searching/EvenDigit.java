package searching;

public class EvenDigit {
    public static void main(String[] args) {
        int[] arr = {100000, 999999, 1234567, 10000000};
        System.out.println(count_even(arr));
    }

    static int count_even(int[] num){
        int count = 0;
        for (int nums : num) {
            if(even(nums)){
                count++;
            }
        }
        return count;
    }

    static boolean even(int nums) {
//        if (nums < 0){
//            nums = nums * -1;
//        }
//        String digit= String.valueOf(nums);

        return count_digit(nums) % 2 == 0;
    }


    static int count_digit(int digit){
        if(digit <0){
            digit = digit*-1;
        }

        if(digit == 0){
            return 1;
        }

        int i = 0;
        while (digit > 0){
            i++;
            digit = digit /10;
        }
        return i;
    }
}
