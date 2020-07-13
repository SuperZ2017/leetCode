package Tree;

import data.TreeNode;

public class a129 {


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int i) {
        if (root == null)
            return 0;
        int tmp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return tmp;

        return dfs(root.left, tmp) + dfs(root.right, tmp);
    }


}
