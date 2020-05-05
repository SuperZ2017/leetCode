package DP.String;


/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]。
 *
 * 如果 s1[i]==s2[j]，那么这个字符一定在 lcs 中；
 * 否则的话，s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，需要丢弃一个。
 */
public class a1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i < len1+1; i++) {
            for (int j = 1; j < len2+1; j++) {
                // 找到一个 lcs 中的字符
                if (ch1[i-1] == ch2[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    // 谁能让 lcs 最长，就听谁的
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[len1][len2];
    }
}
