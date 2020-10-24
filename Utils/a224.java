package Utils;

import java.util.Stack;

/**
 * 基本计算器
 */
public class a224 {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // sign 代表正负
        int sign = 1, res = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1)))
                    cur = cur * 10 + s.charAt(++i) - '0';
                res = res + sign * cur;
            } else if (ch == '+')
                sign = 1;
            else if (ch == '-')
                sign = -1;
            else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')')
                res = stack.pop() * res + stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        a224 a224 = new a224();
        String s = "((1+(5+2)-3)+(6+8))";
        System.out.println(a224.calculate(s));
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.toString());
//        System.out.println(sb == null);
//        System.out.println(sb.length() == 0);
    }

}
