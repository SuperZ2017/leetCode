package Tree;

import data.TreeNode;

import java.util.*;


/**
 * 合并二叉树
 */
public class a617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

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
        int right = dfs(node.right) +1;
        if (Math.abs(left - right) > 1)
            res = false;

        return Math.max(left, right);
    }
}
