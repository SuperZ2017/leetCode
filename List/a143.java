package List;

import data.ListNode;

/**
 * 重排链表
 */
public class a143 {

    // 将链表分为两部分，将后面链表反转，合并两部分链表
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head, fast = head, prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }

        ListNode head1 = slow;
        prev.next = null;

        ListNode head2 = reverse(head1);
        mergeList(head, head2);
    }

    static ListNode reverse(ListNode head) {
        if (head == null)
            return head;

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    static void mergeList(ListNode head, ListNode head2) {
        while (head2 != null) {
            ListNode temp = head.next;
            head.next = head2;
            head =  head.next;
            head2 = temp;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);


//        ListNode head1 = new ListNode(6);
//        head1.next = new ListNode(5);
//        head1.next.next = new ListNode(4);
//        ListNode l1 = reverse(head);
        reorderList(head);
        System.out.println(1);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = lenListNode(head);
        int x = 1;
        while (x < len) {
            ListNode h = dummy.next;
            ListNode pre = dummy;
            while (h != null) {
                ListNode h1 = h;
                int i = x;
                for (; h != null && i > 0; i--)
                    h = h.next;
                if (i > 0) break;
                ListNode h2 = h;
                int y = x;
                for (; h != null && y > 0; y--)
                    h = h.next;

                int c1 = x;
                int c2 = x - y;
                // 合并
                while (c1 > 0 && c2 > 0) {
                    if (h1.val > h2.val) {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    } else {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    }

                    pre = pre.next;
                }
                pre.next = c1 > 0 ? h1 : h2;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            x *= 2;

        }
        return dummy.next;
    }

    private int lenListNode(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        return len;
    }
}
