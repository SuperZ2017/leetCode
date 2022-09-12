package Tree;

import data.TreeNode;

/**
 * 将有序数组转为二叉搜索树
 */
public class a108 {

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    TreeNode helper(int left, int right) {
        if (left > right)
            return null;

        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }
}
