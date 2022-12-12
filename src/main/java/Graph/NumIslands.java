package Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/06/8:30
 * @Description:
 */
public class NumIslands {
    boolean[][] visited;
    public int numIslands(char[][] grid) {

        if (grid == null || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int sum = 0;
        //初始化被访问数组
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //遍历数组 如果未被访问并且是陆地则加一
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return;
        if (grid[i][j] == 0) return;
        //向四周进行dfs遍历
        if (grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
        return;
    }
}
