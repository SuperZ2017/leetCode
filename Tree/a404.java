package Tree;

import data.TreeNode;

/**
 * 左叶子之和
 */
public class a404 {

    public int result = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        //是否是当前节点的左孩子
        //当前节点的左孩子是不是叶子节点（叶子结点：没有左右孩子）
        if(root.left != null && (root.left.left == null && root.left.right == null)){
            result = result + root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;
    }
}
