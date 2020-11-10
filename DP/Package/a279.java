package DP.Package;

import java.util.Arrays;

/**
 * 完全平方数
 */
public class a279 {

    public int numSquares(int n) {
        int num = (int) Math.sqrt(n) + 1;
        int[] coins = new int[num];
        for (int i = 1; i < num; i++) {
            coins[i - 1] = i * i;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[n];
    }
}
