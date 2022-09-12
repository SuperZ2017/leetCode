package Tree;

import data.TreeNode;

import java.util.LinkedList;

/**
 * 给定一个二叉树和一个目标和，
 * 判断该树中是否存在根节点到叶子节点的路径，
 * 这条路径上所有节点值相加等于目标和。
 */
public class a112 {

    // 递归，减去节点的值，直到为 0
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if (root.left == null && root.right == null)
            return (sum == 0);

        return hasPathSum1(root.left, sum) || hasPathSum1(root.right, sum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        stack.add(root);
        sumStack.add(sum - root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            int curr_sum = sumStack.pollLast();
            if (node.left == null && node.right == null && curr_sum == 0)
                return true;

            if (node.right != null) {
                stack.add(node.right);
                sumStack.add(curr_sum - node.right.val);
            }

            if (node.left != null) {
                stack.add(node.left);
                sumStack.add(curr_sum - node.left.val);
            }

        }
        return false;
    }
}
