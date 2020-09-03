package DP.Buy_and_Sell_Stock;

/**
 * 买卖股票，最多交易2次
 */
public class a123 {

    public int maxProfit(int[] prices) {
        // dp_i10 表示 第i天 最多交易一次 没有持有股票 时候的金额。
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            // 注意 k 表示最多交易次数，先买再卖为 1 次，只有进行买入动作才意味着开始了下一个交易
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }

        return dp_i20;
    }
}
