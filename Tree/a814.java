package Tree;

import data.TreeNode;

/**
 * 二叉树剪枝
 */
public class a814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }
}
