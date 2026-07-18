package recursion;

public class Pattern {
    public static void main(String[] args) {
        System.out.println("Triangle Forward: ");
        triangle2(4, 0);
        System.out.println();
        System.out.println("Triangle Backward: ");
        triangle(4, 0);
        System.out.println("Triangle Number: ");
        triangleNo(4, 0);
    }
    static void triangle(int r, int c){
        if(r == 0){
            return;
        }
        if (c < r){
            System.out.print("*");
            triangle(r, c + 1);
        }else{
            System.out.println();
            triangle(r - 1, 0);
        }
    }

    static void triangleNo(int r, int c){
        if(r == 0){
            return;
        }
        if (c < r){
            System.out.print(c);
            triangleNo(r, c + 1);
        }else{
            System.out.println();
            triangleNo(r - 1, 0);
        }
    }

    static void triangle2(int r, int c){
        if(r == 0){
            return;
        }
        if (c < r){
            triangle2(r, c + 1);
            System.out.print("*");
        }else{
            triangle2(r - 1, 0);
            System.out.println();
        }
    }
}
