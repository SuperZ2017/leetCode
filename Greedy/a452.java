package Greedy;

import java.util.Arrays;

public class a452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        // 按end升序排列
        Arrays.sort(points, (a, b) -> a[1] - b[1]);

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = points[0][1];
        for (int[] interval : points) {
            int start = interval[0];
            if (start > x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }

        return count;
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty())
            return true;

        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right++;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }

        return true;
    }

}
