package Cracking_the_coding_interview;

import data.ListNode;

/**
 * 环路检测
 *
 * 1. 检测链表是否有循环
 * 2. 找到循环开始的位置
 */
public class s0208 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
