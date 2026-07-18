package pattern;

public class Pattern {
    public static void main(String[] args) {
        System.out.println("Pattern 1");
        pattern31(4);
        System.out.println("Pattern 2");
        pattern1(4);
        System.out.println("Pattern 3");
        pattern2(4);
        System.out.println("Pattern 4");
        pattern3(4);
        System.out.println("Pattern 5");
        pattern30(4);
        System.out.println("Pattern 6");
        pattern17(4);
    }

    static void pattern31(int n){
        int N = 2*n;
        for (int i = 0; i <= N; i++) {
            for (int j = 0 ; j <= N; j++) {
                int index =n - Math.min(Math.min(i ,j), Math.min(N - i, N  - j));
                System.out.print(index);
            }
            System.out.println();
        }
    }

    static void pattern1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern2(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    static void pattern3(int n){
        for (int i = n; i >= 1; i--) {
            for (int j = i; j >= 1 ; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1 ; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    
    static void pattern30(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i ; j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1 ; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void pattern17(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
        for (int i = n-1; i >= 1; i--) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            for (int j = 2; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}


//    *
//   * *
//  * * *
// * * * *
//* * * * *
// * * * *
//  * * *
//   * *
//    *