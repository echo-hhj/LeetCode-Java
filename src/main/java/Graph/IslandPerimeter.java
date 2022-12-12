package Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/05/8:43
 * @Description:
 */
public class IslandPerimeter {
    boolean[][] visited;

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int sum = 0;
        //记录被访问的数组
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    sum += dfs(grid, i, j);
                }
            }
        }
        return sum;
    }

    private int dfs(int[][] grid, int i, int j) {
        //如果超出边界说明是周长
        if (!(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length)) return 1;
        //如果是水域也是周长的一部分
        if (grid[i][j] == 0) return 1;
        //如果当前节点已被访问那就返回0
        if (visited[i][j]) return 0;
        //设置当前点已被访问
        visited[i][j] = true;
        return dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);
    }
}
