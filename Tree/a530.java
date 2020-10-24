package Tree;

import data.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 */
public class a530 {

    int min;
    int prev;
    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        prev = -1;
        inorder(root);
        return min;
    }

    public void inorder(TreeNode root){
        if (root == null){
            return;
        }
        inorder(root.left);
        if (prev == -1){
            prev = root.val;
        }
        else {
            min = Math.min(min, root.val - prev);
            prev = root.val;
        }
        inorder(root.right);
    }
}
