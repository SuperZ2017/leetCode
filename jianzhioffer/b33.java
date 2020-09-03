package jianzhioffer;

import java.util.Stack;

public class b33 {

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        // 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
        int root = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历
        for (int i = postorder.length-1; i >= 0; i--) {
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if (postorder[i] > root)
                return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                root = stack.pop();
            stack.add(postorder[i]);
        }

        return true;
    }
}
