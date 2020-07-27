package DP;


/**
 * 通配符匹配，？匹配单个，*匹配任意（包括空）
 */
public class a44 {

    public boolean isMatch(String s, String p) {
        // dp[i][j]表示s截止到第i个位置(s[i-1])的子串与p截止到第j个位置(p[j-1])的子串是否匹配
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        dp[0][0] = true;

        for (int j = 1; j <= p.length(); j++)
            if (p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];

        // 注意 i,j表示的是s和p中第几个字符，对应的索引索引是i-1,j-1
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                // * 可以匹配任意字符包括空字符，所以考虑 dp[i-1][j-1],dp[i-1][j],dp[i][j-1]这前面已处理过的三个结果
                // 但其实 dp[i-1][j-1]不用考虑，因为考虑dp[i-1][j]时也会执行这个if，还是会考虑到dp[i-1][j-1]
                if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                // 当前位置是 ？,可以匹配任意单个字符，所以和前一个位置结果一样
                // p当前位置字符和s当前字符一样，所以跟前一个位置匹配结果一样
                } else if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
