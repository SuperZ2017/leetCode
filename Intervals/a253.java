package Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 会议室 2
 */
public class a253 {

    /**
     * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],…] (si < ei)，
     * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
     *
     * Input: [[0, 30],[5, 10],[15, 20]]
     * Output: 2
     *
     * Input: [[7,10],[2,4]]
     * Output: 1
     */


    /**
     * 先对所有的区间按照开始时间进行排序，使用小根堆保存每个会议的结束时间，堆的大小表示了现在已经占用了多少个会议室。
     * 我们要申请会议室的时候，先看是不是可以释放会议室，将已经占用的会议室释放。
     *
     *  遍历判断每个区间的开始时间是否大于等于小根堆中最小元素（最早结束时间），
     *  如果大于等于，说明堆里面有个会议要结束了，将其弹出，代表释放了一个会议室；否
     *  则，说明堆里面的已经在使用的会议室没有空闲，只能新增加一个会议室。
     */
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (!queue.isEmpty() && interval[0] >= queue.peek()) {
                queue.poll();
            }
            queue.offer(interval[1]);
        }
        return queue.size();
    }

}
