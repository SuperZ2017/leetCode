package DP;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class a322 {


    // 状态转移：amount = 10 -> 11，即将 10 需要的最小硬币数加 1，dp[i] 表示 金币为 i 需要的最少个数 dp;
    public static int coinChange(int[] coins, int amount) {

        // amount 最多需要 amount 个 1 元，所以初始化为 amount + 1，相当于正无穷；
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            // 求所有子问题的最小解
            for (int coin : coins) {
                if (i - coin < 0)   // 无解，跳过
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
