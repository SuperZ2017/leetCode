package List;

import data.ListNode;

import java.util.Arrays;

/**
 * 对链表进行插入排序
 */
public class a147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = head, cur = head.next;

        while (cur != null) {
            if (pre.val < cur.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                while (p.next.val < cur.val && p.next != cur)
                    p = p.next;

                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                cur = pre.next;
            }
        }

        return dummy.next;
    }


    public static void main(String[] args) {
//        int[] nums = {0, 1, 0, 1, 0, 1, 3};
//        int[] bitSums = new int[32];
//        for (int num : nums)
//            for (int i = 0; i < 32; i++)
//                bitSums[i] += (num >> (31 - i)) & 1;
//
//        System.out.println(Arrays.toString(bitSums));

//        for (int i = 0; i < 32; i++)
//            System.out.print((8 >> (31 - i)) & 1);

        int res = 0;
        for (int i = 0; i < 32; i++)
            res = res << 1;

        System.out.println(0 << 1);
        System.out.println(res);
    }
}
