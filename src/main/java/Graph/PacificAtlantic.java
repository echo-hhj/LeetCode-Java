package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/11/13:58
 * @Description:
 */
public class PacificAtlantic {
    int[][] gird;
    int row, col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //存放结果
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights[0].length == 0) return res;
        gird = heights;
        row = heights.length;
        col = heights[0].length;
        //创建两个数组来判断是否能流入对应的海洋
        boolean[][] Pacific = new boolean[row][col];
        boolean[][] Atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //对靠近太平洋的进行dfs进行遍历
                if (i == 0 || j == 0) {
                    dfs(i, j, Pacific);
                }
                //对靠近大西洋的进行dfs进行遍历
                if (i == row - 1 || j == col - 1) {
                    dfs(i, j, Atlantic);
                }
            }

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //再次遍历，如果同时为真再加入结果列表
                if (Pacific[i][j] && Atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int i, int j, boolean[][] bool) {
        bool[i][j] = true;
        for (int[] d : direction) {
            //遍历周围的位置
            int x = i + d[0], y = j + d[1];
            //如果超出边界则继续下一个
            if (x < 0 || x >= row || y < 0 || y >= col) continue;
            //如果已访问，或者值比当前小，说明水流不到当前位置
            if (bool[x][y] || gird[x][y] < gird[i][j]) continue;
            dfs(x, y, bool);
        }
    }
}
