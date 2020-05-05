package List;

import data.ListNode;

/**
 * 删除链表中倒数第N个结点
 */
public class a19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode l1 = pre;
        ListNode l2 = pre;

        while (n-- > 0)
            l1 = l1.next;

        while (l1.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        l2.next = l2.next.next;

        // 删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
        return pre.next;

    }
}
