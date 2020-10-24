package DP.String;

/**
 * 最长回文子序列
 */
public class a516 {

    // 在子串 s[i..j] 中，最长回文子序列的长度为 dp[i][j]
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // 如果只有1个字符，则长度为1
        for (int k = 0; k < n; k++)
            dp[k][k] = 1;

        // 遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，
        // 这样可以保证每个子问题都已经算好了。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n-1];
    }
}
