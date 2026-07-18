package searching;

public class SearchInString {
    public static void main(String[] args) {
        String[] arr = {"Ninad", "Shreya", "Mohit", "Akshat"};
        String target = "shreya";
        System.out.println(linearSearch(arr, target));
    }

    static int linearSearch(String[] num, String target){
        if(num.length == 0){
            return -1;
        }

        for (int i = 0; i < num.length; i++) {
            if(num[i].equalsIgnoreCase(target)){
                return i;
            }
        }
        return -1;
    }
}
