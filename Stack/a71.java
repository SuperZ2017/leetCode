package Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化路径
 *
 * 把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.
 */
public class a71 {

    public static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!item.isEmpty() && !item.equals("."))
                stack.push(item);
        }
        String res = "";
        for (String d : stack)
            res = "/" + d + res;

        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }

}
