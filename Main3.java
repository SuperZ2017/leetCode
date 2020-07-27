import data.ListNode;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('<', '>');
        map.put('[', ']');

        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = false;

            for (int i = 0; i < ch.length; i++) {
                char tmp = ch[i];
                if (map.containsKey(tmp)) {
                    stack.push(tmp);
                } else if (stack.isEmpty()) {
                    System.out.println(0);
                    flag = true;
                    break;
                } else if (!stack.isEmpty()) {
                    if (map.get(stack.peek()) == tmp)
                        stack.pop();
                    else {
                        System.out.println(0);
                        flag = true;
                        break;
                    }
                }
            }

            int i = stack.isEmpty() ? 1 : 0;
            if (!flag)
                System.out.println(i);
            flag = false;
            stack.clear();
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>();
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;


        for (ListNode listNode : lists)
            queue.add(listNode);

        while (!queue.isEmpty()) {

            ListNode node1 = queue.poll();
            dummy.next = node1;
            dummy = dummy.next;
            if (dummy.next != null)
                queue.add(dummy.next);

        }

        return dummy.next;
    }

}
