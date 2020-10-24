package Tree;

import data.TreeNode;

import java.util.Arrays;

/**
 * 二叉树的最大深度
 */
public class a104 {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left > right ? left : right;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5};
        int[] num1 = Arrays.copyOfRange(num, 0, 2);
        System.out.println(num1);

    }


}
