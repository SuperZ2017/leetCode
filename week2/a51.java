package week2;

import java.util.*;

public class a51 {

    private List<List<String>> res;
    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> masterSet = new HashSet<>();
    private Set<Integer> solveSet = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) return null;
        res = new LinkedList<>();
        char[][] board = new char[n][n];
        for (char[] chars : board) Arrays.fill(chars, '.');
        backtrack(board, 0);
        return res;
    }


    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res.add(charToString(board));
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!valid(board, row, col))
                continue;
            updateRecords(board, row, col);
            backtrack(board, row + 1);
            updateRecords(board, row, col);
        }
    }

    private static List<String> charToString(char[][] board) {
        List<String> result = new LinkedList<>();
        for (char[] chars : board)
            result.add(String.valueOf(chars));
        return result;
    }

    private boolean valid(char[][] board, int row, int col) {
        return !colSet.contains(col)
                && !masterSet.contains(row - col)
                && !solveSet.contains(row + col);
    }

    private void updateRecords(char[][] board, int row, int col) {
        if (!colSet.contains(col)) {
            board[row][col] = 'Q';
            colSet.add(col);
            masterSet.add(row - col);
            solveSet.add(row + col);
        } else {
            board[row][col] = '.';
            colSet.remove(col);
            masterSet.remove(row - col);
            solveSet.remove(row + col);
        }
    }
}
