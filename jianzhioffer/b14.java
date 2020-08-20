package jianzhioffer;

/**
 * 剪绳子
 */
public class b14 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++)
            for (int j = 1; j < i; j++)
                dp[i] = Math.max(dp[i],
                        Math.max((i-j) * j, dp[j] * (i - j)));

        return dp[n];
    }
}
