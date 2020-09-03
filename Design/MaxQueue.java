package Design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {

    // deque 队首元素就是队列的最大值
    Deque<Integer> deque;
    Queue<Integer> queue;
    public MaxQueue() {
        deque = new ArrayDeque<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        if (!deque.isEmpty())
            return deque.peekFirst();
        else
            return -1;
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;

        int ans = queue.peek();
        if (ans == deque.peekFirst())
            deque.pollFirst();

        queue.poll();
        return ans;
    }
}
