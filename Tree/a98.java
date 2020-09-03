package Tree;

import data.TreeNode;

import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class a98 {

    public boolean isValidBST(TreeNode root) {

        return isValid(root, null, null);

    }

    public boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int val = node.val;
        if (lower != null && lower >= val)
            return false;
        if (upper != null && upper <= val)
            return false;
        if (!isValid(node.right, val, upper))
            return false;
        if (!isValid(node.left, lower, val))
            return false;
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        stack.add(root);

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }

        return true;
    }
}
