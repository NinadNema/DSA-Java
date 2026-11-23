package leetcode.medium;

import java.util.*;

public class LC1352_ProductOfTheLastKNumbers {
    public static void main(String[] args) {
        LC1352_ProductOfTheLastKNumbers lc = new LC1352_ProductOfTheLastKNumbers();

    }

    List<Integer> prefix;

    public LC1352_ProductOfTheLastKNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

//  Time Complexity - O(1)
    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        }
    }

//  Time Complexity - O(1)
    public int getProduct(int k) {
        if (k >= prefix.size()) {
            return 0;
        }

        int n = prefix.size();
        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }
}
