package week2;

import data.TreeNode;

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
}
