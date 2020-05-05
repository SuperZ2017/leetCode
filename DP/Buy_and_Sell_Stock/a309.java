package DP.Buy_and_Sell_Stock;

/**
 * 买卖股票 含冷冻期
 */
public class a309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        // 代表 dp[i-2][0];
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // 解释：第 i
            // buy 的时候，要从 i-2 的状态转移，⽽不是 i-1 。
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }
}
