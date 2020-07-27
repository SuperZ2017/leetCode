package Cracking_the_coding_interview;

import data.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 移出重复节点
 */
public class s0201 {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            set.add(cur.val);
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }


}
