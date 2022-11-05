package ArrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/27/7:44
 * @Description:
 */
public class rotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        int length = matrix.length;
        for (int a = 0; a < length; ++a){
            System.out.println(Arrays.toString(matrix[a]));
        }

    }
    public static void rotate(int[][] matrix) {
        int temp;

        //先按对角线翻转
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < i; ++j) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //再按中间翻转
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix.length/2; ++j) {
                temp = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
