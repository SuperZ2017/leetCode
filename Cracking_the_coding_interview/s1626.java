package Cracking_the_coding_interview;

import java.util.Stack;

/**
 * 计算器
 */
public class s1626 {

    public int calculate(String s) {
        char[] chars = s.replace(" ", "").toCharArray();
        Stack<Integer> stack = new Stack<>();
        int res = 0, n = chars.length;
        // 跟踪前一个操作符
        char pre = ' ';
        for (int i = 0; i < n; i++) {
            // 因为整数可能不止一位，这个地方要注意把整数取完整
            StringBuilder sb = new StringBuilder();
            while (i < n && Character.isDigit(chars[i]))
                sb.append(chars[i++]);

            int num = Integer.parseInt(sb.toString());
            // 然后查看其前一个运算符情况讨论
            if (pre == '+')
                stack.push(num);
            else if (pre == '-')
                stack.push(-num);
            else if (pre == '*')
                stack.push(stack.pop() * num);
            else if (pre == '/')
                stack.push(stack.pop() / num);
            else
                stack.push(num);

            if (i < n)
                pre = chars[i];
        }

        while (!stack.isEmpty())
            res += stack.pop();

        return res;
    }


}
