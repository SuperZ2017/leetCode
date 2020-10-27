package List;

import data.ListNode;

/**
 * 反转链表中的一部分
 */
public class a92 {

    public ListNode reverseBetween_1(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        // 找到翻转前一个节点
        for (int i = 0; i < m - 1; i++)
            pre = pre.next;
        ListNode node = null;
        ListNode cur = pre.next;
        // 翻转
        for (int i = 0; i < n - m + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = node;
            node = cur;
            cur = tmp;
        }
        // 将翻转部分 和 原链表拼接
        pre.next.next = cur;
        pre.next = node;
        return dummy.next;
    }

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
