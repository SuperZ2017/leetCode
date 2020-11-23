package DP;

/**
 * 一个环上有10个点，编号为0-9，从0点出发，每步可以顺时针到下一个点，也可以逆时针到上一个点，
 *
 * 求：经过n步又回到0点有多少种不同的走法
 *
 * d(k, j) = d(k-1, j-1) + d(k-1, j+1);
 *
 * d(k, j)表示从点 j 走 k 步到达原点 0 的方法数，因此可以转化为他相邻的点经过 k-1 步回到原点的问题，
 */
public class d1 {

    public int getSteps(int n, int k) {

        if (n == 0)
            return 1;
        // 如果只有2个环，则偶数有1个方法，奇数不能到达
        if (n == 2) {
            if (k % 2 == 0)
                return 1;
            else
                return 0;
        }

        // 从点 n 走 k 步到达原点 0 的方法数
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;

        // 0 步到达任意点有0种方法
        for (int i = 1; i < n; i++)
            dp[0][i] = 0;

        for (int j = 1; j <= k; j++) {
            for (int i = 0; i < n; i++) {
                dp[j][i] = dp[j - 1][(i - 1 + n) % n] + dp[j - 1][(i + 1) % n];
            }
        }

        return dp[k][0];
    }
}
