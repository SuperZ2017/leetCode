package jianzhioffer;

import data.TreeNode;

/**
 * 树的子结构
 */
public class b26 {

    public final boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;

        if (A.val == B.val)
            return dfs(A, B);

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    private boolean dfs(TreeNode A, TreeNode B) {
        if (B == null)
            return true;

        if (A == null)
            return false;

        if (A.val == B.val)
            return dfs(A.left, B.left) && dfs(A.right, B.right);
        else
            return false;
    }
}
