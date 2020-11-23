package DP.Buy_and_Sell_Stock;

/**
 * 买卖股票，最多交易一次
 */
public class a121 {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            // 今天没有持有股票 --> 1. 昨天持有，今天不变  2. 昨天持有，今天卖了
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // 今天持有股票 --> 1. 昨天持有，今天不变  2. 昨天没有，今天买入
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
