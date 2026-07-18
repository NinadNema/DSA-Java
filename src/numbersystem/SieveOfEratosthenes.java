package numbersystem;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int num = 36;

        boolean[] prime = new boolean[num+1];
        sieve(num, prime);
    }
    static void sieve(int n, boolean[] prime){
        for (int i = 2; i*i <= n; i++) {
            if(!prime[i]){
                for (int j = i*2; j <= n; j+= i) {
                    prime[j] = true;
                }
            }
        }

        for (int j = 2; j <= n; j++) {
            if(!prime[j]){
                System.out.print(j + " ");
            }
        }
    }
}
