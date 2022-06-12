package Tree;

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class a116 {

    // 按层处理
    public Node connect(Node root) {

        if (root == null)
            return root;

        Node leftmost = root;

        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                // 连接同一个父节点的两个子节点
                head.left.next = head.right;
                if (head.next != null) {
                    // 连接不同父节点之间子节点
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }



}
