package Cracking_the_coding_interview;

import data.ListNode;

/**
 * 回文链表
 */
public class s0206 {

    public boolean isPalindrome(ListNode head) {
        // 找到中间点位置，从这里开始反转后半段链表
        // 再次找到中点位置，中点与head开始进行对比，中途有不同的返回false
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy; // 遍历后slow指向的是mid的前一个
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode head2 = reverse(slow.next);
        slow.next = null;
        while (head != null && head2 != null) {
            if (head.val != head2.val) {
                return false;
            } else {
                head = head.next;
                head2 = head2.next;
            }
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre.next;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return pre.next;
    }


}
