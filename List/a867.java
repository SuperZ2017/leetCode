package List;

import data.ListNode;

/**
 * 链表的中间节点
 */
public class a867 {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null)
                return slow;
            else
                fast = fast.next;

            if (fast.next == null)
                return slow.next;
            else
                fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
