package ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/27/8:12
 * @Description:
 */
public class clockwiseTraversal {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int left = 0;   //左边界
        int right = matrix[0].length - 1;   //右边界
        int top = 0;    //上边界
        int bottom = matrix.length - 1;     //下边界
        int num = matrix.length * matrix[0].length;   //矩阵元素数量

        while (num > 0) {
            //遍历最上层元素
            for (int i = left; i <= right && num > 0; ++i){
                res.add(matrix[top][i]);
                --num;  //遍历元素减一
            }
            ++top;  //上边界加1
            for (int i = top; i <= bottom && num > 0; ++i){
                res.add(matrix[i][right]);
                --num;
            }
            --right;
            for (int i = right; i >= left && num > 0; --i){
                res.add(matrix[bottom][i]);
                --num;
            }
            --bottom;
            for (int i = bottom; i >= top && num > 0; --i){
                res.add(matrix[i][left]);
                --num;
            }
            ++left;
        }
        return res;
    }
}
