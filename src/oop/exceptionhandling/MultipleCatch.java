package oop.exceptionhandling;

public class MultipleCatch {

    public static void main(String[] args) {

        int[] arr = {1,2,3};

        try {

            System.out.println(arr[5]);

            int ans = 10 / 0;

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Array Index Error");

        } catch (ArithmeticException e) {

            System.out.println("Arithmetic Error");

        } catch (Exception e){

            System.out.println("General Exception");
        }
    }
}