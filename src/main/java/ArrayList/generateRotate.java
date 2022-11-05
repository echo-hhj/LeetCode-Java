package ArrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/27/9:16
 * @Description:
 */
public class generateRotate {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int i = 0; i < res.length; ++i) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //确定上下左右边界
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        //记录总的数字
        int num = n * n;
        int count = 1;
        while (count <= num) {
            for (int i = left; i <= right && count <= num; ++i) {
                res[top][i] = count++;
            }
            ++top;
            for (int i = top; i <= bottom && count <= num; ++i) {
                res[i][right] = count++;
            }
            --right;
            for (int i = right; i >= left && count <= num; --i) {
                res[bottom][i] = count++;
            }
            --bottom;
            for (int i = bottom; i >= top && count <= num; --i) {
                res[i][left] = count++;
            }
            ++left;
        }
        return res;
    }
}
