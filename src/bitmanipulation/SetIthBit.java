package bitmanipulation;

public class SetIthBit {
    public static void main(String[] args) {
        int n = 100;
        System.out.println(setIth(n, 3));
    }

    static int setIth(int n, int k){
        int t = (1<<(k-1));
        return n | t;
    }
}
