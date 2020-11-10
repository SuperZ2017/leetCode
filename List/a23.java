package List;

import data.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 */
public class a23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val); // 最小堆
        for (ListNode list : lists)
            if (list != null)
                queue.add(list);

        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;    // 每次poll()都会将一个链表全部弄出去，但是每次只需要链表中的一个结点
            if (p.next != null) //故，还要将剩下的结点添加到queue中
                queue.add(p.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(9);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] lists = {node3, node2, node1};
        ListNode a = mergeKLists(lists);
        System.out.println(1);
    }
}
