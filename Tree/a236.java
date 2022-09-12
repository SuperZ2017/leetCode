package Tree;

import data.TreeNode;

import java.util.*;

//具体思路：
//        （1） 如果当前结点 root 等于 NULL，则直接返回 NULL
//        （2） 如果 root 等于 p 或者 q ，那这棵树一定返回 p 或者 q
//        （3） 然后递归左右子树，因为是递归，使用函数后可认为左右子树已经算出结果，用 left 和 right 表示
//        （4） 此时若 left 为空，那最终结果只要看 right；若 right 为空，那最终结果只要看 left
//        （5） 如果 left 和 right 都非空，因为只给了 p 和 q 两个结点，都非空，说明一边一个，因此 root 是他们的最近公共祖先
//        （6） 如果 left 和 right 都为空，则返回空（其实已经包含在前面的情况中了）

/**
 * 二叉树最近公共祖先
 */
public class a236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null ) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        //找到p和q节点即可退出循环，不用遍历整一棵树
        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = queue.poll();
            if (root.left != null) {
                queue.add(node.left);
                map.put(node.left, node);
            }

            if (root.right != null) {
                queue.add(node.right);
                map.put(node.right, node);
            }
        }

        //用于存储P节点的所有先辈节点(包括自己)
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }

        //在p的先辈节点集合中找到q的最近先辈节点是哪一个
        while (!set.contains(q)) {
            q = map.get(q);
        }

        return q;
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);

        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }
}
