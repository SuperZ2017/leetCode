package Greedy;

import java.util.Arrays;

/**
 * 无重叠区间
 */
public class a435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }


    // 算出这些区间中最多有几个互不相交的区间
    private int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0)
            return 0;

        // 按end升序排列
        Arrays.sort(intvs, (a, b) -> a[1] - b[1]);

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }

        return count;
    }
}
