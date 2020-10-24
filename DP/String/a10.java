package DP.String;

/**
 * 字符串匹配
 */
public class a10 {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp 表示 s 的前 i 个字符与 p 中的前 j 个字符是否能够匹配。
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;


        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 匹配 0 次，浪费了一个字符 + 星号的组合
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1))
                        // dp[i - 1][j] 匹配 s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；
                        // dp[i][j] 不匹配字符，将该组合扔掉，不再进行匹配
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                } else {
                    if (matches(s, p, i, j))
                        dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0)
            return false;

        if (p.charAt(j - 1) == '.')
            return true;

        return s.charAt(i - 1) == p.charAt(j - 1);
    }


//    public static boolean isMatch(String s, String p) {
//        if (p.isEmpty())
//            return s.isEmpty();
//
//        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
//
//        if (p.length() >= 2 && p.charAt(1) == '*') {
//            return isMatch(s, p.substring(2)) ||    // 忽视模式串中这一部分，从*后面开始
//                    (first_match && isMatch(s.substring(1), p));   // *前面的相匹配，则从字符串后面开始匹配，意味着 * 匹配多个，如aa a*
//        } else {
//            return first_match && isMatch(s.substring(1), p.substring(1));
//        }
//    }

    public static void main(String[] args) {
        System.out.println(true || false);
    }
}
