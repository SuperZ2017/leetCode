package List;

import data.ListNode;

/**
 * 删除排序链表中重复的元素 二
 */
public class a82 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode node = p;

        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                ListNode temp = node.next;
                while (temp != null && temp.next != null && temp.val == temp.next.val)
                    temp = temp.next;
                node.next = temp.next;
            } else
                node = node.next;
        }

        return p.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println(deleteDuplicates(head));
        System.out.println(1);
    }
}
