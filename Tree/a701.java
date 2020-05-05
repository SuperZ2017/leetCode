package Tree;

import data.TreeNode;


/**
 * 二叉搜索数组中的插入操作
 */
public class a701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (root.val < val)
            root.right = insertIntoBST(root.right, val);
        if (root.val > val)
            root.left = insertIntoBST(root.left, val);

        return root;
    }
}
