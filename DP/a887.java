package DP;

/**
 * 鸡蛋掉落
 */
public class a887 {

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        int m = 0;
        // 给你 K 鸡蛋，N 层楼，让你求最坏情况下最少的测试次数 m
        // 给你 K 个鸡蛋，测试 m 次，最坏情况下最多能测试 N 层楼。(与原问题等价)
        while (dp[K][m] < N) {
            m++;

            // 这个 m 为什么要减一而不是加一？之前定义得很清楚，这个 m 是一个允许的次数上界，而不是扔了几次。
            for (int k = 1; k <= K; k++)
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
        }

        return m;
    }
}
