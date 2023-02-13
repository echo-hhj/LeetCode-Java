package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/13/20:12
 * @Description:
 */
public class ShellSort {
    public static int[] sort(int[] array) {
        int len = array.length;
        if (len < 2) return array;
        //设置初始增量
        int gap = len / 2;
        //current之前的都是有序的
        int current, i, j;
        while (gap > 0) {
            for (i = gap; i < len; i++) {
                //数组下标是从0开始的，故current之前的元素是有序的
                current = array[i];
                //进行插入排序
                for (j = i; j >= gap && current < array[j - gap]; j -= gap) {
                    //如果当前元素比待插入的元素大则向后移动
                    array[j] = array[j - gap];
                }
                //插入元素
                array[j] = current;
            }
            gap = gap / 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 9, 6, 11, 5, 1, 14, 2, 10, 4, 8, 7, 13, 3};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
