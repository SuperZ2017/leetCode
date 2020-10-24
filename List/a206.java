package List;

import data.ListNode;

/**
 * 反转单链表
 */
public class a206 {

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // 迭代
    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
