package searching;

public class SqrtX {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(mySqrt(n));
    }

    static int mySqrt(int x) {
        int s = 1;
        int e = x;
        int res = 0;

        while(s <= e){
            int mid = s+(e-s)/2;

            if(mid > x/mid){
                e = mid-1;
            } else if (mid < x/mid) {
                s = mid+1;
                res = mid;
            }else{
                return mid;
            }
        }
        return res;
    }
}
