package Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 */
public class a1091 {

    // 表示8个方向可以进行移动，｛1,1｝表示右下方
    private static int[][] directions = {{0,1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {-1,-1}, {-1,0}, {-1,1}};
    private int row, col;

    public int shortestPathBinaryMatrix(int[][] grid) {
        row = grid.length;
        col = grid[0].length;

        if (grid[0][0] == 1 || grid[row-1][col-1] == 1)
            return -1;

        Queue<int[]> pos = new LinkedList<>();
        grid[0][0] = 1;  // 直接用grid[i][j]记录从起点到这个点的最短路径长。按照题意 起点也有长度1
        pos.add(new int[]{0,0});

        // 第二个条件不满足时，说明已经有路径到达右下角了，就可以停止搜索。
        while (!pos.isEmpty() && grid[row - 1][col - 1] == 0) {  // 求最短路径 使用BFS
            int[] xy = pos.remove();
            int preLength = grid[xy[0]][xy[1]];
            for (int i = 0; i < 8; i++) {
                int newX = xy[0] + directions[i][0];
                int newY = xy[1] + directions[i][1];
                if (inGrid(newX, newY) && grid[newX][newY] == 0) {  // grid[newX][newY] 表示没有访问过的可通行的点
                    pos.add(new int[]{newX, newY});
                    grid[newX][newY] = preLength + 1;
                }
            }
        }

        return grid[row - 1][col - 1] == 0 ? -1 : grid[row - 1][col - 1];
    }

    private boolean inGrid(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
