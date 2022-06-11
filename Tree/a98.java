package Tree;

import data.TreeNode;

import java.util.LinkedList;

/**
 * 验证二叉搜索树
 */
public class a98 {

    // 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
    long pre = Long.MIN_VALUE;
    public boolean isValidBST_1(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST_1(root.left)) return false;

        if (root.val >= pre) return false;

        pre = root.val;

        if (!isValidBST_1(root.right)) return false;

        return true;
    }

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
