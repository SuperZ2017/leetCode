package jianzhioffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class b13 {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, k, m, n, visited);
    }


    private int dfs(int i, int j, int k,int m, int n, boolean[][] visited) {
        int count = 0;
        if (i < m && j < n && i > 0 && j > 0 && !valid(i, j, k) && visited[i][j])
            visited[i][j] = true;
            count = 1 + dfs(i + 1, j, k, m, n, visited) +
                        dfs(i - 1, j, k, m, n, visited) +
                        dfs(i, j + 1, k, m, n, visited) +
                        dfs(i, j - 1, k, m, n, visited);
        return count;
    }

    private static boolean valid(int i, int j, int k) {
        int a = 0;
        while (i % 10 != 0) {
            a += i % 10;
            i /= 10;
        }

        while (j % 10 != 0) {
            a += j % 10;
            j /= 10;
        }

        if (k < a)
            return false;
        return true;
    }


    // BSF
    public int movingCount1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            if (i < 0 || j < 0 || i >= m || j >= n || !valid(i, j, k) || visited[i][j])
                continue;
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j+1});
        }
        return res;
    }

    public static void main(String[] args) {
        int i = 35, j = 38, k = 18;
        System.out.println(valid(i, j, k));
    }
}
