package Tree;

import data.TreeNode;

/**
 * 二叉树的坡度
 */
public class a563 {

    int tilt = 0;
    public int findTilt(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root);
        return tilt;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        tilt += Math.abs(left - right);
        // 返回一个点所有子树的之和
        return left + right + root.val;
    }

}
