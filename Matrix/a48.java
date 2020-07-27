package Matrix;

/**
 * 旋转图像（矩阵）
 */
public class a48 {

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 行列互换
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

       // 每行互换
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = temp;
            }
        }
    }
}
