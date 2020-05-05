package Tree;

import data.TreeNode;

import java.util.Arrays;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 */
public class a106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length-1]) {
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);
                int[] in_right = Arrays.copyOfRange(inorder, i+1, inorder.length);
                int[] post_left = Arrays.copyOfRange(postorder, 0, i);
                int[] post_right = Arrays.copyOfRange(postorder, i, postorder.length - 1);
                root.left = buildTree(in_left, post_left);
                root.right = buildTree(in_right, post_right);
                break;
            }
        }

        return root;
    }
}
