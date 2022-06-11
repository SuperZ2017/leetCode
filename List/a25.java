package List;

import data.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * K 个一组翻转链表
 */
public class a25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p1 = dummy;
        while (true) {
            int count = 0;
            ListNode temp = head;
            while (temp != null && count < k) {
                stack.push(temp);
                temp = temp.next;
                count++;
            }

            if (count != k) {
                p1.next = head;
                break;
            }

            while (!stack.isEmpty()) {
                p1.next = stack.pop();
                p1 = p1.next;
            }

            p1.next = temp;
            head = temp;

        }

        return dummy.next;
    }


    // 尾插法
    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;

        while (true) {
            int count = 0;
            while (tail != null && count != k) {
                tail = tail.next;
                count++;
            }

            if (tail == null) break;
            ListNode head1 = pre.next;
            while (pre.next != tail) {
                ListNode cur = pre.next;
                pre.next = cur.next;
                cur.next = tail.next;
                tail.next = cur;
            }
            pre = head1;
            tail = head1;
        }

        return dummy.next;
    }
}
