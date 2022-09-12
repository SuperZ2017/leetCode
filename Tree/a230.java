package Tree;

import data.TreeNode;

import java.util.Stack;

/**
 * 二叉搜索树中第K小的元素
 * 中序遍历即可
 */
public class a230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }

        return 0;
    }
}
