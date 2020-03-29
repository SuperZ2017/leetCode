package week2;

public class a37 {

    public void solveSudoku(char[][] board) {

        if (board == null || board.length == 0)
            return;
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (int c = 1; c <= 9; c++) {
                        char c1 = String.valueOf(c).charAt(0);
                        if (isValid(board, i, j, c1)) {
                            board[i][j] = c1;
                            // 递归调用
                            if (solve(board))
                                return true;
                            else
                                // 前面不通，还原成空格
                                board[i][j] = '.';
                        }
                    }
                    // 1~9都不能填，则不行
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}
