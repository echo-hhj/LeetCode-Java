package Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/07/10:45
 * @Description:
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid[0].length == 0) return 0;
        //初始化最大面积为0
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    //找出最大的面积
                    maxArea = Math.max(maxArea, dfs(grid, i, j));

            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        //超出边界则返回0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        //如果是陆地，则遍历后变为水，并递归遍历邻近
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            return dfs(grid, i - 1, j) +
                    dfs(grid, i + 1, j) +
                    dfs(grid, i, j - 1) +
                    dfs(grid, i, j + 1) + 1;
        }
        return 0;
    }
}
