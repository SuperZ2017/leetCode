package Math;

import java.util.LinkedList;

/**
 * 根据逆波兰表示法，求表达式的值。
 */
public class a150 {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        int num1, num2;
        for (String s : tokens) {
            if (s.equals("+")) {
                num1 = stack.poll();
                num2 = stack.poll();
                stack.push(num1 + num2);
            } else if (s.equals("-")) {
                num1 = stack.poll();
                num2 = stack.poll();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                num1 = stack.poll();
                num2 = stack.poll();
                stack.push(num2 * num1);
            } else if (s.equals("/")) {
                num1 = stack.poll();
                num2 = stack.poll();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.poll();
    }
}
