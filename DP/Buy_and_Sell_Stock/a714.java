package DP.Buy_and_Sell_Stock;

/**
 * 买卖股票的最佳时机含手续费
 */
public class a714 {

    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // 相当于买⼊股票的价格升⾼了。
            //在第⼀个式⼦⾥减也是⼀样的，相当于卖出股票的价格减⼩
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] -fee);
        }

        return dp_i_0;
    }
}
