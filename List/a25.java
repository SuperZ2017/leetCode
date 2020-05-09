package List;

import data.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class a25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(0);
        ListNode p1 = dummy;
        while (true) {
            int count = 0;
            ListNode temp = head;
            while (temp != null && count <= k) {
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
}
