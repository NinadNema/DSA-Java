package numbersystem;

public class PrimeNumber {
    public static void main(String[] args) {
        int num = 36;

        System.out.println(isPrime(num));
    }
    static boolean isPrime(int num){
        if(num <= 1) {
            return false;
        }
        else{
            for (int i = 2; i*i <= num; i++) {
                if(num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
