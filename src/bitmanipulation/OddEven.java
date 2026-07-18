package bitmanipulation;

class OddEven {
    public static void main(String[] args) {
        int a = 6;
        if ((a & 1) == 0){
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }
}