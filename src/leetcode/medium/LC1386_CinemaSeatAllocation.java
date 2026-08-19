package leetcode.medium;

import java.util.HashMap;

public class LC1386_CinemaSeatAllocation {
    public static void main(String[] args) {
        LC1386_CinemaSeatAllocation lc = new LC1386_CinemaSeatAllocation();
        int n = 3;
        int[][] arr = {
                {1,2},
                {1,3},
                {1,8},
                {2,6},
                {3,1},
                {3,10}
        };

        System.out.println(lc.maxNumberOfFamilies(n, arr));
    }

//  Time Complexity - O(n)

    public int maxNumberOfFamilies(int n, int[][] reservedSeats){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] num : reservedSeats){
            int row = num[0];
            int col = num[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int mid = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        long grp = 0;

        grp += (long) (n - map.size()) * 2;

        for (int mask : map.values()){
            boolean leftAvailable = (mask & left) == 0;
            boolean rightAvailable = (mask & right) == 0;
            boolean midAvailable = (mask & mid) == 0;

            if(leftAvailable && rightAvailable){
                grp += 2;
            }else if(leftAvailable || midAvailable || rightAvailable){
                grp += 1;
            }
        }

        return (int) grp;
    }
}


