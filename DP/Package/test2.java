package DP.Package;

/**
 * 完全背包
 *
 * 有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。
 *
 * 第 i 种物品的体积是 vi，价值是 wi。
 *
 * 求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
 * 输出最大价值。
 */
public class test2 {

    public int getMaxValue(int N, int V, int[] v, int[] w) {
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++)
                dp[j] = Math.max(dp[j] , dp[j - v[i]] + w[i]);
        }

        return dp[V];
    }
}
