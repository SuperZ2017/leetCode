package Cracking_the_coding_interview;

import data.ListNode;

/**
 * 删除中间节点
 */
public class s0203 {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
