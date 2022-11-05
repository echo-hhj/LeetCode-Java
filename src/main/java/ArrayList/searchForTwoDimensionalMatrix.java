package ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/27/9:59
 * @Description:
 */
public class searchForTwoDimensionalMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        System.out.println(searchMatrix(matrix, 9));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        //将左下角元素设为基准元素，若当前元素小于目标值则向右移动，否则向上移动
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int i = row, j = 0;
        //数组越界就跳出循环
        while (i >= 0 && j <= col) {
            if (matrix[i][j] > target) {
                --i;
            } else if (matrix[i][j] < target) {
                ++j;
            } else {
                return true;    //找到元素
            }
        }
        return false;
    }
}
