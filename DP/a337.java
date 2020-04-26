package DP;

import data.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class a337 {

//    public int rob(TreeNode root) {
//        int[] res = dp(root);
//        return Math.max(res[0], res[1]);
//    }
//
//    private int[] dp(TreeNode root) {
//        if (root == null)
//            return new int[]{0,0};
//        int[] left = dp(root.left);
//        int[] right = dp(root.right);
//        int rob = root.val + left[0] + right[0];
//        int not_rob = Math.max(left[0], left[1])
//                    + Math.max(right[0], right[1]);
//        return new int[]{not_rob, rob};
//    }

    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        int do_it = root.val +
                (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) +
                (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));

        int not_do = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, not_do);
        memo.put(root, res);
        return res;
    }


}
