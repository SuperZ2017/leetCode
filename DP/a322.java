package DP;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class a322 {


    // 状态转移：amount = 10 -> 11，即将10需要的最小硬币数加1，dp[i]表示 金币为i需要的最少个数dp;
    public static int coinChange(int[] coins, int amount) {

        // amount最多需要amount个1元，所以初始化为amount+1，相当于正无穷；
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
