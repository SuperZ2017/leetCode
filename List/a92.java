package List;

import data.ListNode;

/**
 * 反转链表中的一部分
 */
public class a92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1)
            return reverseN(head, n);

        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
