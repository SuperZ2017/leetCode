package Tree;

import data.TreeNode;

import java.util.*;

/**
 * 二叉树的最小深度
 */
public class a111 {

    public int minDepth(TreeNode root) {

        if (root == null)
            return 0;
        // 没有左子树
        if (root.left == null)
            return 1 + minDepth(root.right);
        // 没有右子数
        if (root.right == null)
            return 1 + minDepth(root.left);

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        int result = 1 + Math.min(left , right);

        return result;
    }

    public int minDepth1(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int depth = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }

        return -1;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {

            while (root.left != null) {
                stack.add(root.left);
                root = root.left;
            }

            TreeNode node = stack.poll();
            res.add(node.val);
            root = root.right;

        }

        return res;
    }
}
