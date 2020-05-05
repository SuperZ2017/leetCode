package Tree;

import data.TreeNode;

import java.util.*;

/**
 * 二叉树层序遍历
 */
public class a102 {

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list= new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(list);
        }
        return result;

    }


    List<List<Integer>> res = new ArrayList<>();

    // DFS
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null)
            return;

        if (res.size() == level)
            res.add(new ArrayList<>());
        if (node.left != null)
            dfs(node.left, level + 1);
        if (node.right != null)
            dfs(node.right, level + 1);
    }
}
