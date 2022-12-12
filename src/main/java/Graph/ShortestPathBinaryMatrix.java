package Graph;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/27/10:53
 * @Description:
 */
public class ShortestPathBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] != 0) {
            return -1;
        }
        //行列大小
        int row = grid.length;
        int col = grid[0].length;
        //向周围探索的方向
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        //存储节点
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        //步伐长度
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++step;
            for (int i = 0; i < size; i++) {
                //取出当前位置
                int crow = queue.peek()[0];
                int ccol = queue.peek()[1];
                queue.poll();
                if (grid[crow][ccol] != 0) continue;
                //找到目标返回
                if (crow == row - 1 && ccol == col - 1) return step;
                //标记访问
                grid[crow][ccol] = 1;
                //下一个位置
                for (int[] next : direction) {
                    int nr = crow + next[0];
                    int nc = ccol + next[1];
                    //如果下一个位置的坐标在范围内且不等于1且没有被访问过加入队列
                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] != 1) {
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] gird = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(gird));
    }
}
