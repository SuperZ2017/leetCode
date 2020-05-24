package Stack;

import java.util.Stack;

/**
 * 验证栈序列
 */
public class a946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = popped.length;
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int x : pushed) {
            stack.push(x);

            while (!stack.isEmpty() && stack.peek() == popped[j] && j < N){
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
