package Stack;

import data.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 最长有效括号
 */
public class a32 {

    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }





    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[amount] = Integer.MIN_VALUE;
        dp[0] = 0;

        for (int i = 1; i <= amount; i++)
            for (int coin : coins) {
                if (i < coin)
                    continue;
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }

        if (dp[amount] == Integer.MIN_VALUE)
            return -1;
        return dp[amount];
    }






}