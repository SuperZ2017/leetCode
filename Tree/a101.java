package Tree;

import data.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 对称二叉树
 */
public class a101 {

    public boolean isSymmetric(TreeNode root) {

        boolean flag = isSymmetric1(root,root);
        return flag;
    }

    private boolean isSymmetric1(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null)
            return true;

        if (node1 == null && node2 != null)
            return false;

        if (node1 != null && node2 == null)
            return false;

        return (node1.val == node2.val)
                && isSymmetric1(node1.left, node2.right)
                && isSymmetric1(node1.right, node2.left);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }

        return true;
    }
}
