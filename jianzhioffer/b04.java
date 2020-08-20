package jianzhioffer;

/**
 * 二维数组中的查找
 */
public class b04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    // 从右上角开始遍历
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col > cols) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
