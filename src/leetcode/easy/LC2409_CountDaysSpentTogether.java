package leetcode.easy;

public class LC2409_CountDaysSpentTogether {
    public static void main(String[] args) {
        LC2409_CountDaysSpentTogether lc = new LC2409_CountDaysSpentTogether();

        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";

        System.out.println(lc.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob));
    }

//  Time Complexity - O(1)
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceArrive = getDay(arriveAlice);
        int aliceLeave = getDay(leaveAlice);

        int bobArrive = getDay(arriveBob);
        int bobLeave = getDay(leaveBob);

        int start = Math.max(aliceArrive, bobArrive);
        int end = Math.min(aliceLeave, bobLeave);

        if (start > end) {
            return 0;
        }

        return end - start + 1;
    }

    private int getDay(String date) {
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));

        int[] days = {
                31, 28, 31, 30, 31, 30,
                31, 31, 30, 31, 30, 31
        };

        int total = day;

        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }

        return total;
    }
}
