package Stack;

import java.util.Stack;

/**
 * 每日温度
 */
public class a739 {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i])
                stack.pop();
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }

        return res;
    }
}
