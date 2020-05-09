package Design;

/**
 * 155，最小栈
 *
 * 直接用一个链表即可实现栈的基本功能，那么最小值该怎么得到呢？
 * 我们可以在 Node 节点中增加一个 min 字段，这样的话每次加入一个节点的时候，
 * 我们同时只要确定它的 min 值即可。
 */
class MinStack {

    class Node {
        int value;
        int min;
        Node next;

        Node(int value, int min) {
            this.value = value;
            this.min = min;
            next = null;
        }
    }

    Node head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    //每次加入的节点放到头部
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            //当前值和之前头结点的最小值较小的做为当前的 min
            Node n = new Node(x, Math.min(x, head.min));
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        if (head != null)
            head = head.next;
    }

    public int top() {
        if (head != null)
            return head.value;
        return -1;
    }

    public int getMin() {
        if (null != head)
            return head.min;
        return -1;
    }
}
