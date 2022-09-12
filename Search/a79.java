package Search;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 单词搜索
 */
public class a79 {

    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backTrack(i, j, 0, word, board))
                    return true;
            }
        }

        return false;
    }

    private boolean backTrack(int i, int j, int idx, String word, char[][] board) {
        if (idx == word.length())
            return true;

        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 ||
                board[i][j] != word.charAt(idx) || visited[i][j])
            return false;

        visited[i][j] = true;
        if (backTrack(i + 1, j, idx + 1, word, board)
                || backTrack(i - 1, j, idx + 1, word, board)
                || backTrack(i, j + 1, idx + 1, word, board)
                || backTrack(i, j - 1, idx + 1, word, board))
            return true;
        visited[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
//        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> "123");
//
//        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "456");
//
//        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> "789");
//
//        List<String> res = new ArrayList<>();
//        CompletableFuture.allOf(f1, f2, f3).thenRun(() -> {
//            res.add(f1.join());
//            res.add(f2.join());
//            res.add(f3.join());
//        });
//
//        System.out.println(res);
//


        for (int i = 0; i < 3; i++) {
            CompletableFuture.runAsync(() -> System.out.println("A"))
                    .thenRunAsync(() -> System.out.println("B"))
                    .thenRunAsync(() -> System.out.println("C")).join();
        }
    }
}
