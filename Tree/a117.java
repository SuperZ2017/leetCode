package Tree;

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class a117 {

    Node last = null, nextStart = null;
    public Node connect(Node root) {
        if (root == null)
            return null;

        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.next != null)
                    handle(p.left);
                if (p.right != null)
                    handle(p.right);
            }
            start = nextStart;
        }

        return root;

    }

    public void handle(Node p) {
        if (last != null)
            last.next = p;
        if (nextStart == null)
            nextStart = p;
        last = p;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

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
