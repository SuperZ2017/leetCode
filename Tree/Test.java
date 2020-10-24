package Tree;

import data.TreeNode;

import java.util.Arrays;

// A(B(,),C(d,e)) 生成二叉树
public class Test {

    public static void main(String[] args) {
        String s = "1(2(,),3(4,5))";
//        TreeNode root = genTree(s);
        String[] strs = s.split(",");
        System.out.println(Arrays.toString(strs));
    }

    private static TreeNode genTree(String s) {
        if (s.length() >= 0) {
            TreeNode node = new TreeNode(Integer.valueOf(s.charAt(0)));
            if (s.length() == 1)
                return node;
            String s1 = s.substring(2, s.length() - 1);
            if (s1.length() == 1)
                return node;
            int i;
            for (i = 1; i < s1.length() - 2; i++){
                if (s1.charAt(i - 1) == ')' && s1.charAt(i) == ',')
                    break;
            }

            String s2 = s1.substring(0, i);
            String s3 = s1.substring(i + 1);
            node.left = genTree(s2);
            node.right = genTree(s3);
            return node;
        }
        return null;
    }


}
