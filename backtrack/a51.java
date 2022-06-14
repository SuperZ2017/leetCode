package backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后
 */
public class a51 {

    static List<List<String>> res;

    public static List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board)
            Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }

    private static void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }

        int n = board[row].length;
        // 在当前行的每一列都可能放置皇后
        for (int col = 0; col < n; col++) {
            // 排除可以互相攻击的格子
            if (!isValid(board, row, col))
                continue;
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行放皇后
            backtrack(board, row + 1);
            // 撤销选择
            board[row][col] = '.';
        }
    }

    private static List<String> charToString(char[][] array) {
        List<String> result = new LinkedList<>();
        for (char[] chars : array) {
            result.add(String.valueOf(chars));
        }
        return result;
    }

    private static boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // 检查列是否有冲突
        for (int i = 0; i < n; i++)
            if (board[i][col] == 'Q')
                return false;

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
//        solveNQueens(8);
        System.out.println(1001 & 1100);
    }
}
