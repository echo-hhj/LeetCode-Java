package ArrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/27/10:51
 * @Description:
 */
public class diagonalTraversal {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));

    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat == null) return null;
        if (mat.length == 0) return new int[]{};
        int num = mat.length * mat[0].length;
        int[] result = new int[num];
        int row = 0;
        int col = 0;
        int count = 0;  //记录数组下标
        while (count < num) {
            result[count++] = mat[row][col];
            //数组下标之和为偶数向右上遍历
            if ((row + col) % 2 == 0) {

                //如果碰到右边界行数加1
                if (col== mat[0].length - 1) {
                    ++row;
                } else if (row == 0) {
                    ++col;       //如果碰到上边界列数加1
                } else {
                    //向右上方移动
                    --row;
                    ++col;
                }
            } else {//数组下标之和为奇数向左下遍历
                //如果碰到下边界列数加1
                if (row == mat.length - 1) {
                    ++col;
                } else if (col == 0) {  //如果碰到左边界行数加1
                    ++row;
                } else {
                    //向左下方移动
                    ++row;
                    --col;
                }
            }
        }
        return result;
    }
}
