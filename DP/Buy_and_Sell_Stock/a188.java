package DP.Buy_and_Sell_Stock;

/**
 * 买卖股票，最多交易k次
 */
public class a188 {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // 一次交易由买入和卖出构成，至少需要两天。
        // 所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。
        if (k > n / 2)
            return maxProfit(prices);

        int[][][] dp = new int[n + 1][k + 1][2];

        // 第 0 天持有股票 是不可能的事
        for (int i = 0; i < k + 1; i++) {
            dp[0][i][1]=Integer.MIN_VALUE;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[n][k][0];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            int temp = dp_i_0;
            // 今天没有持有股票 --> 1. 昨天持有，今天不变  2. 昨天持有，今天卖了
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // 今天持有股票 --> 1. 昨天持有，今天不变  2. 昨天没有，今天买入 (昨天的金额-今天股票钱)
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }

        return dp_i_0;
    }
}
