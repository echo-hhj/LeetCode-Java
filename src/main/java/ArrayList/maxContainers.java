package ArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/26/8:35
 * @Description:
 */
public class maxContainers {
    public static void main(String[] args) {
        int[] s = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(s));
    }
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;    //记录水池最大值
        int res;    //记录当前窗口的面积
        int left = 0, right = height.length - 1;    //标记窗口左右边界
        while (left < right) {         // 当左边界小于右边界的时候
            //记录当前长度较小的那块边界长度
            int temp = Math.min(height[left], height[right]);
            //计算当前窗口面积并与最大值进行比较
            res = temp * (right - left);
            if (res > max) max = res;
            if (temp == height[left]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
