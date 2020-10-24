package Tree;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class a113 {

    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        pathSum(root, sum, new ArrayList<Integer>());
        return res;
    }

    public void pathSum(TreeNode root, int sum, ArrayList<Integer> temp){
        if(root == null)
            return ;

        temp.add(root.val);
        sum -= root.val;
        // ps 这里不需要 return
        if(root.left == null && root.right == null && sum == 0){
            res.add(new ArrayList<>(temp));
        }

        pathSum(root.left,sum, temp);
        pathSum(root.right,sum, temp);

        temp.remove(temp.size() - 1);
    }
}
