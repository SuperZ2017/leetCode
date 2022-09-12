package List;

import data.ListNode;

import java.math.BigDecimal;

/**
 * 两两交换链表中的节点
 */
public class a24 {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")).toString());
    }
}
