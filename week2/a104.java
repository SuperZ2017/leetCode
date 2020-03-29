package week2;

import data.TreeNode;

public class a104 {

    public int maxDepth(TreeNode root) {

        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
