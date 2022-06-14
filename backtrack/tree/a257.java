package backtrack.tree;

import data.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 */
public class a257 {

    List<String> ans;

    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<>();
        if (root == null)
            return ans;
        dfs(root, "");
        return ans;
    }

    void dfs(TreeNode node, String str) {
        if (node.left == null && node.right == null) {
            ans.add(str + node.val);
            return;
        }

        String temp = node.val + "->";
        str += temp;
        if (node.left != null)
            dfs(node.left, str);
        if (node.right != null)
            dfs(node.right, str);
    }
}
