package Search;

/**
 * 岛屿的数量
 */
public class a200 {

    boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid,r,c);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (!inArea(grid,r,c))
            return;
        if (grid[r][c] != '1')
            return;
        grid[r][c] = '2';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }
}
