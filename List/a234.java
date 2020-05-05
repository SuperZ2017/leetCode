package List;

import data.ListNode;

/**
 * 回文链表
 */
public class a234 {

    ListNode left;
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if(right==null) return true;
        boolean res = traverse(right.next);
        res = res && (right.val==left.val);
        left = left.next;
        return res;
    }
}
