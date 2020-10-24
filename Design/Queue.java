package Design;

import data.ListNode;

/**
 * 链表实现队列
 */
public class Queue {

    private ListNode head; //头结点
    private ListNode tail; //尾结点
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(int val) {
        // 向表尾添加元素
        ListNode oldTail = tail;
        tail = new ListNode(val);
        tail.next = null;
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        N++;
    }

    public int dequeue() {
        int val = head.val;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        N--;
        return val;
    }

}
