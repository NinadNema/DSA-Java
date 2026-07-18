package bitmanipulation;

public class ResetIthBit {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(resetIth(n, 3));
    }

    static int resetIth(int n, int k){
        int t = ~(1<<(k-1));
        return n & t;
    }
}
