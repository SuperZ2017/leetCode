package DP;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * 最大的正方形
 */
public class a221 {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int rows = matrix.length, columns = matrix[0].length;
        // dp(i,j) 表示以 (i, j)(i,j) 为右下角，且只包含 1 的正方形的边长最大值。
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    }
                }
                maxSide = max(maxSide, dp[i][j]);
            }
        }

        return maxSide * maxSide;
    }
}
