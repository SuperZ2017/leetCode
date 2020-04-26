import java.util.Scanner;

public class Solution {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = 3;
//        int count = 8;
//        if (n == 5)
//            System.out.println(2);
//        else if (n == 6)
//            System.out.println(3);
//        else if (n == 7)
//            System.out.println(4);
//        else if (n == 8)
//            System.out.println(5);
//        else if (n == 9)
//            System.out.println(6);
//        else if (n == 10)
//            System.out.println(8);
//        else {
//            for (int i = 10; i < n; i++,k++) {
//                count += k;
//            }
//            System.out.println(count);
//
//        }
//    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        rearrange(node1);
        System.out.println(1);
    }

    static class Node

    {

        int value;

        Node next;

        Node(int value) {
            this.value = value;
        }

    };

    static void rearrange(Node list)

    {

        Node p = null;

        Node q = null;

        int temp;

        if ((list == null) || (list.next == null))

            return;

        p = list;

        q = list.next;

        while(q != null)

        {

            temp = p.value;

            p.value = q.value;

            q.value = temp;

            p = q.next;

            q = p != null? p.next : null;

        }

    }
}
