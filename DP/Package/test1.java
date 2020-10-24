package DP.Package;

/**
 * 01 背包问题
 *
 * 有 N 件物品和一个容量是 V 的背包。每件物品只能使用一次。
 *
 * 第 i 件物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */
public class test1 {

    // dp[i][j] 表示只能选择前i个物品，背包容量为j的情况下，背包中物品的最大价值
    public int getMaxValue(int N, int V, int[] v, int[] W) {
        int[][] dp = new int[N + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (j >= v[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + W[i]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[N][V];
    }

    // 状态压缩，由于状态只与 i 和 i - 1 有关，可以让第二层循环从后向前，可以避免 i - 1 被覆盖
    public int getMaxValue_1(int N, int V, int[] v, int[] W) {
        int[] dp = new int[V + 1];
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--)
                dp[j] = Math.max(dp[j], dp[j - v[i]] + W[i]);

        }

        return dp[V];
    }

}
