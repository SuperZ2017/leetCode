package Tree;

import data.TreeNode;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 */
public class a437 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int result = countPath(root, sum);
        int a = pathSum(root.left, sum);
        int b = pathSum(root.right, sum);
        return result + a + b;
    }

    int countPath(TreeNode node, int sum) {
        if (node == null)
            return 0;
        sum -= node.val;
        int result = sum == 0 ? 1 : 0;
        return result + countPath(node.left, sum) + countPath(node.right, sum);
    }
}
