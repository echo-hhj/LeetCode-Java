package Graph;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/10/10:26
 * @Description:
 */
public class Solve {
    public void solve(char[][] board) {
        if (board == null || board[0].length == 0) return;
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //判断是否是边界
                boolean edge = (i == 0 || i == row - 1 || j == 0 || j == col - 1);
                if (edge && board[i][j] == 'O') {
                    dfs(board, i, j, row, col);
                }
            }
        }

        //处理完之后再遍历整个数组
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }

        }
    }

    private void dfs(char[][] board, int i, int j, int row, int col) {
        //如果超出边界则返回
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        //如果是X或者已被访问的也返回
        if (board[i][j] == 'X' || board[i][j] == '#') return;
        if (board[i][j] == 'O') {
            //标记当前为#，并dfs遍历周围
            board[i][j] = '#';
            dfs(board, i + 1, j, row, col);
            dfs(board, i - 1, j, row, col);
            dfs(board, i, j + 1, row, col);
            dfs(board, i, j - 1, row, col);
        }
    }


}
