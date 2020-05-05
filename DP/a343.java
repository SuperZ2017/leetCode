package DP;

/**
 * 整数拆分
 */
public class a343 {

    public int integerBreak(int n) {
        // dp[i] 表示整数 i 对应的最大乘积
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            for(int j = 1; j < i; j++)
                //当拆分为两个数时候 j 乘以 i-j，（n拆成j和i-j）
                // 当拆分为多个数字时候就为j乘以dp[i-j]（当n为i-j时候最大的乘积）
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[j]*(i-j)));
        return dp[n];
    }
}
