package week2;

import data.TreeNode;

import java.util.*;

public class a102 {

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root == null)
            return Collections.emptyList();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
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
            return ;

        if (res.size() == level)
            res.add(new ArrayList<>());

        res.get(level).add(node.val);
        if (node.left != null)
            dfs(node.left, level + 1);
        if (node.right != null)
            dfs(node.right, level + 1);
    }
}
