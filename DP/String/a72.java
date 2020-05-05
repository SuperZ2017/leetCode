package DP.String;

/**
 * 编辑距离
 * dp[i][j]表示 s1[0..i] 和 s2[0..j] 的最小编辑距离
 * dp 函数的 base case 是 i,j 等于 -1，而数组索引至少是 0，所以 dp 数组会偏移一位，因为字符串有一个下标先到-1就结束了。
 */
public class a72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // 多开一行一列是为了保存边界条件，即字符长度为 0 的情况，这一点在字符串的动态规划问题中比较常见
        int[][] dp = new int[m+1][n+1];

        // 初始化：当 word 2 长度为 0 时，将 word1 的全部删除
        for (int i = 0; i <= m; i++)
            dp[i][0] = i;
        // 当 word1 长度为 0 时，就插入所有 word2 的字符
        for (int j = 0; j <= n; j++)
            dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = min(
                            dp[i-1][j]+1,
                            dp[i][j-1]+1,
                            dp[i-1][j-1]+1
                    );
                }
            }
        }
        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
