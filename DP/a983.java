package DP;

/**
 * 最低票价
 */
public class a983 {

    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        // days中最后一天再加上1
        int[] dp = new int[days[len - 1] + 1];

        int day_index = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i == days[day_index]) {
                //  若 i 走到了待处理天数，则从三种方式中选一个最小的
                dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0],
                        Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
                day_index++;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}
