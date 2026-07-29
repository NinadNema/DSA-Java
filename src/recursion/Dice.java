package recursion;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        int d = 4;
        dice("", d);
        System.out.println(diceRet("", d));
    }

//  Approach 1
    static void dice(String p, int up){
        if(up == 0){
            System.out.println(p);
            return;
        }

        for (int i = 1; i <= 6 && i <= up ; i++) {
            dice(p + i, up -i);
        }
    }

//  Approach 2 - Returning in ArrayList
    static ArrayList<String> diceRet(String p, int up){
        if(up == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= up ; i++) {
            ans.addAll(diceRet(p + i, up -i));
        }
        return ans;
    }
}
