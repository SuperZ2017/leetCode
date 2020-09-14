package backtrack;

/**
 * 解数独
 */
public class a37 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    boolean backtrack(char[][] board, int i, int j) {
        int m = 9, n = 9;

        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return backtrack(board, i + 1, 0);
        }

        if (i == m)
            return true;

        // 如果该位置是预设的数字，不用我们操心
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法的数字，就跳
            if (!isValid(board, i, j, ch))
                continue;
            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1))
                return true;
            board[i][j] = '.';
        }

        return false;
    }

    // 判断 board[i][j] 是否可以填入 n
    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) return false;
            // 判断列是否存在重复
            if (board[i][c] == n) return false;
            // 判断 3 x 3 方框是否存在重复
            // (r/3) * 3 确定他所在的子数独在第一个三行，还是第二个三行，还是第三个三行
            // (c/3) * 3可以确定它所在的子数独是前三列还是中散列还是后三列
            if (board[(r/3)*3 + i/3][(c/3)*3 + i%3] == n)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(2/3*3);
    }

}
