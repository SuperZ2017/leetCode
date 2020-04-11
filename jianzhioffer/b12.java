package jianzhioffer;

public class b12 {

    public boolean exist(char[][] board, String word) {

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 边界判断，要最后判断 board[i][j] != words[k]
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != words[k])
            return false;
        if (k == words.length - 1)
            return true;
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1)
                     || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k +1 );
        board[i][j] = temp;
        return res;
    }
}
