package Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 滑动窗口中的最大值
 */
public class a239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque 保存的是下标
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 窗口滑动，队头出列
            if (i >= k-1 && deque.peekFirst() <= i-k)
                deque.pollFirst();

            // 队头保持最大值

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();

            deque.addLast(i);
            if (i >= k - 1)
                list.add(deque.peekFirst());
        }

        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            arr[i] = list.get(i);
        return arr;
    }
}
