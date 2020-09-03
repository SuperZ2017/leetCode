package jianzhioffer;

import data.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树的第k大节点
 *
 * 二叉搜索树的 中序遍历  倒序 为 递减序列 。
 */
public class b54 {

    public int  kthLargest (TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.right;
            }

            p = stack.pop();
            count++;
            if (count == k)
                return p.val;
            p = p.left;
        }

        return 0;
    }


}
