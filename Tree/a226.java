package Tree;

import data.TreeNode;

import java.util.LinkedList;

/**
 * 翻转二叉树
 */
public class a226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        return root;
    }
}
