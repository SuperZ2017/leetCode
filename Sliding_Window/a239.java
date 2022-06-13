package Sliding_Window;

import java.util.*;

/**
 * 滑动窗口中的最大值
 */
public class a239 {

    /**
     * TODO rewrite
     * 使用双端队列，队头保持始终最大值，队尾到队头是单调递增的
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // deque 保存的是下标
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 窗口滑动，队头出列
            if (i >= k - 1 && deque.peekFirst() <= i - k)
                deque.pollFirst();

            // 队头保持最大值，将小于当前值的元素从队尾出队，然后将元素在队尾入队
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            deque.addLast(i);
            if (i >= k - 1)
                list.add(deque.peekFirst());
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        maxSlidingWindow(nums, k);
    }
}
