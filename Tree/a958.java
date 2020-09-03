package Tree;

import data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断是否是完全二叉树
 *
 * 层序遍历序列为：[1, 2, 3, 4, 5, 6, 7, 8, null, null, 9]，其中 null 出现在了9前面，所以不合法
 */
public class a958 {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode prev = root;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (prev == null && node != null)
                return false;
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            }
            prev = node;
        }

        return true;
    }
}
