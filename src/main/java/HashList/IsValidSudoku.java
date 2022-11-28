package HashList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/21/15:43
 * @Description: 请你判断一个 9 x 9 的数独是否有效
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //判断行列是否有效
        for (int i = 0; i < 9; i++) {
            //判断列是否符合
            boolean[] col = new boolean[9];
            //判断行是否符合
            boolean[] row = new boolean[9];
            for (int j = 0; j < 9; j++) {
                //行
                char c1 = board[i][j];
                if (c1 != '.') {
                    //如果当前数字已经出现过
                    if (row[c1 - '1']) return false;
                    row[c1 - '1'] = true;
                }
                //列
                char c2 = board[j][i];
                if (c2 != '.') {
                    //如果当前数字已经出现过
                    if (col[c2 - '1']) return false;
                    col[c2 - '1'] = true;
                }
            }

        }
        //判断九宫格
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] temp = new boolean[9];
                for (int k = 0; k < 9; k++) {
                    //当前字符
                    char c = board[i + k / 3][j + k % 3];
                    if (c != '.') {
                        if (temp[c - '1']) return false;
                        temp[c - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
