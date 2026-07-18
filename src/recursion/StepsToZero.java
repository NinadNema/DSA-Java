package recursion;

public class StepsToZero {
    public static void main(String[] args) {
        int n = 8;
        int count = 0;
        System.out.println(step_recursion(n, count));
    }

    static int step(int num){
        int count = 0;
        while(num > 0) {
            if (num % 2 == 0) {
                count++;
                num /= 2;
            }else{
                count++;
                num -= 1;
            }
        }
        return count;
    }

    static int step_recursion(int n,int count){
        if (n == 0){
            return count;
        }

        if(n % 2 == 0){
            count++;
            return step_recursion(n / 2, count);
        }else{
            count++;
            return step_recursion(n - 1, count);
        }
    }
}
