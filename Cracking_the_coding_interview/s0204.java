package Cracking_the_coding_interview;

import data.ListNode;

/**
 * 分割链表
 */
public class s0204 {

    public ListNode partition(ListNode head, int x) {
        ListNode less_head = new ListNode(0);
        ListNode more_head = new ListNode(0);
        ListNode less_ptr = less_head;
        ListNode more_ptr = more_head;

        while(head != null){
            if(head.val < x){
                less_ptr.next = head;
                less_ptr = less_ptr.next;
            }else{
                more_ptr.next = head;
                more_ptr = more_ptr.next;
            }
            head = head.next;
        }

        more_ptr.next = null;
        less_ptr.next = more_head.next;
        return less_head.next;
    }


}
