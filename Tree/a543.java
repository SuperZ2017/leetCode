package Tree;

import data.TreeNode;

/**
 * 二叉树的直径
 *
 * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
 */
public class a543 {

    int maxLen = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        len(root);
        return maxLen - 1;
    }

    private int len(TreeNode node) {
        if (node == null)
            return 0;

        int left = len(node.left);
        int right = len(node.right);

        maxLen = Math.max(left + right + 1, maxLen);
        return Math.max(left, right) + 1;
    }
}
