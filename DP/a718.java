package DP;

/**
 * 最长重复子数组
 */
public class a718 {

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        // dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        //考虑到这里 dp[i][j] 的值从 dp[i + 1][j + 1] 转移得到，所以我们需要倒过来，
        // 首先计算 dp[len(A) - 1][len(B) - 1]，最后计算 dp[0][0]
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i+1][j+1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
