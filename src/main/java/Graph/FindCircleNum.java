package Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/08/11:36
 * @Description:
 */
public class FindCircleNum {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected[0].length == 0) return 0;
        //记录省份数量
        int number =  0;
        //设置被访问数组
        visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            //如果当前省份没有被访问过
                if (!visited[i]) {
                    //数量加一并访问当前省份与其余省份的相连情况
                    ++number;
                    dfs(isConnected,i);
                }
            }
        return number;
    }

    private void dfs(int[][] isConnected, int i) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                //将该节点的所有相连且未被访问过的结点全部访问，且将状态置为访问过
                visited[j] = true;
                //再将相连结点递归查找
                dfs(isConnected, j);
            }
        }
    }
}
