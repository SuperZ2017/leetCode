package List;

import data.ListNode;

/**
 * 对链表进行插入排序
 */
public class a147 {

    public ListNode insertionSortList(ListNode head) {
        if (head==null ||head.next==null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head, cur = head.next;

        while (cur != null) {
            if (pre.val < cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                while (p.next.val < cur.val && p.next != cur)
                    p = p.next;

                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }

        return dummy.next;
    }
}
