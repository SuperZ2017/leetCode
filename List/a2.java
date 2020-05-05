package List;

import data.ListNode;

/**
 * 链表中两数相加
 *
 * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 0
 *
 * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
 */
public class a2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carray = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carray;
            carray = sum % 10;
            cur.next = new ListNode(sum / 10);
            cur = cur.next;
            if (l1.next != null)
                l1 = l1.next;
            if (l2.next != null)
                l2 = l2.next;
        }

        if (carray == 1)
            cur.next = new ListNode(1);

        return pre.next;
    }

}
