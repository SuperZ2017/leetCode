package jianzhioffer;

import data.ListNode;

import java.util.Stack;

public class b52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node = null;
        int val = 0;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.add(headB);
            headB = headB.next;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() != stackB.peek())
                break;
            else {
                node = stackA.pop();
                stackB.pop();
            }
        }
        
        return node;

    }
}
