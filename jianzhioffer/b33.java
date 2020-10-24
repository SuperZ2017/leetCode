package jianzhioffer;

import java.util.Stack;

/**
 * 二叉搜索树的后序遍历序列
 */
public class b33 {

    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        // 表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
        int root = Integer.MAX_VALUE;
        // 逆向遍历，就是翻转的先序遍历 (根 -> 右 -> 左)
        for (int i = postorder.length - 1; i >= 0; i--) {
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

    public boolean verifyPostorder1(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    // 寻找 第一个大于根节点 的节点，索引记为 mm 。
    // 此时，可划分出左子树区间 [i,m-1][i,m−1] 、右子树区间 [m, j - 1][m,j−1] 、根节点索引 j 。
    // 左子树区间 [i, m - 1] 内的所有节点都应 < postorder[j] 。而第 1.划分左右子树 步骤已经保证左子树区间的正确性，因此只需要判断右子树区间即可。
    // 右子树区间 [m, j-1] 内的所有节点都应 > postorder[j] 。实现方式为遍历，当遇到 ≤postorder[j] 的节点则跳出；则可通过 p = j判断是否为二叉搜索树。
    boolean recur(int[] postorder, int i, int j){
        // 当 i >= j ，说明此子树节点数量 <= 1 ，无需判别正确性，因此直接返回 true ；
        if(i >= j){
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]){
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]){
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

}
