package List;

import data.ListNode;

/**
 * 旋转链表
 */
public class a61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode old_tail = head;
        int n;
        // 形成一个循环链表
        for (n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        ListNode new_tail = head;
        // 新的链表头是第 (n - k % n) 个节点
        for (int i = 0; i < n- k%n - 1; i++)
            new_tail = new_tail.next;

        ListNode new_head = new_tail.next;
        new_tail.next = null;
        return new_head;
    }
}
