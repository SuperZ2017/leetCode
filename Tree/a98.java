package Tree;

import data.TreeNode;

public class a98 {

    public boolean isValidBST(TreeNode root) {

        return isValid(root, null, null);

    }

    public boolean isValid(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int val = node.val;
        if (lower != null && lower >= val)
            return false;
        if (upper != null && upper <= val)
            return false;
        if (!isValid(node.right, val, upper))
            return false;
        if (!isValid(node.left, lower, val))
            return false;
        return true;
    }
}
