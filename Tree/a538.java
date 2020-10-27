package Tree;

import data.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 *
 * 反中序遍历
 */
public class a538 {

    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        convertBST(root.right);
        root.val += preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }

}
