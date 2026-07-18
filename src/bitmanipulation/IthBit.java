package bitmanipulation;

public class IthBit {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(ithbit(n,3));
    }
    static int ithbit(int n, int k){
        int t = 1 << (k-1);
        if ((n & t) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
}
