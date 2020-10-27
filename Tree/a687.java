package Tree;

import data.TreeNode;

/**
 * 最长同值路径
 */
public class a687 {

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return max;
    }

    public int arrowLength(TreeNode root) {
        if (root == null)
            return 0;

        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        int arrowLeft = 0, arrowRight = 0;

        if (root.left != null && root.left.val == root.val)
            arrowLeft += 1 + left;

        if (root.right != null && root.right.val == root.val)
            arrowRight += 1 + right;

        max = Math.max(arrowLeft + arrowRight, max);
        return Math.max(arrowLeft, arrowRight);
    }

}
