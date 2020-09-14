package Search;

/**
 * 矩阵中的最长递增路径
 */
public class a329 {

    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxLen = 0;
        int[][] memo = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, memo));
            }
        }

        return maxLen;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0)
            return memo[i][j];
        // 只要这个格子被遍历过了，就不会再执行这句话了
        memo[i][j]++;
        for (int[] dir : dirs) {
            int newRow = i + dir[0], newCol = j + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && matrix[newRow][newCol] > matrix[i][j])
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, newRow, newCol, memo) + 1);
        }

        return memo[i][j];
    }

}
