package Cracking_the_coding_interview;

import data.ListNode;

/**
 * 返回倒数第k个节点
 */
public class s0202 {

    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        int i = 0;
        while (i < k) {
            fast = fast.next;
            i++;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
