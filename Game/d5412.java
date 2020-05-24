package Game;

import java.util.Stack;

public class d5412 {

    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int len = startTime.length;

        for (int i = 0; i < len; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] s = {9,8,7,6,5,4,3,2,1};
        int[] e = {10,10,10,10,10,10,10,10,10};
        System.out.println(busyStudent(s, e, 5));
    }




}
