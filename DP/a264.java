package DP;

/**
 * 丑数
 *
 * 让我们从数组中只包含一个丑数数字 1 开始，使用三个指针, 标记所指向丑数要乘以的因子。
 *
 * 在 2*p2，3*p3，5*p5选出最小的丑数并添加到数组中。并将该丑数对应的因子指针往前走一步。
 */
public class a264 {

    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }

        return dp[n-1];
    }
}
