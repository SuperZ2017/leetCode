package Tree;

import data.TreeNode;

/**
 * 平衡二叉树
 */
public class a110 {

    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        dfs(root);
        return res;
    }

    int dfs(TreeNode node) {
        if (node == null)
            return 0;

        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        if (Math.abs(left - right) > 1)
            res = false;

        return Math.max(left, right);
    }
}
