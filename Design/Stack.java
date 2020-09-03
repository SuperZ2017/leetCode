package Design;

import data.ListNode;

/**
 * 链表实现栈
 */
public class Stack {

    private ListNode head;  // 栈顶
    private int N;  // 元素数量

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return N;
    }

    // 头插法
    public void push(int val) {
        // 向栈顶添加元素
        ListNode oldhead = head;
        head = new ListNode(val);
        head.next = oldhead;
        N++;
    }

    public int pop() {
        // 从栈顶删除元素
        int val = head.val;
        head = head.next;
        N--;
        return val;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        int s = stack.pop();
        System.out.println(s);
    }
}
