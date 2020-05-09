package Tree;

import data.TreeNode;

import java.util.Arrays;

/**
 * 二叉树中的最大路径和
 */
public class a124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;

        //计算左边分支最大值，左边分支如果为负数还不如不选择
        int left_max = Math.max(0, dfs(root.left));

        //计算右边分支最大值，右边分支如果为负数还不如不选择
        int right_max = Math.max(0, dfs(root.right));

        //left->root->right 作为路径与历史最大值做比较
        max = Math.max(max, root.val + left_max + right_max);

        // 返回经过root的单边最大分支给上游
        return root.val + Math.max(left_max, right_max);
    }
}
