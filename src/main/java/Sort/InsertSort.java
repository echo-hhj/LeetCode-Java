package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2023/02/04/20:19
 * @Description:
 */
public class InsertSort {
    public static void sort(int[] array) {
        //第一个是有序的故直接从第二个元素开始插入排序
        for (int i = 1; i < array.length; i++) {
            //记录要插入的元素
            int tmp = array[i];
            int j = i;
            //如果待插入元素比前一个元素小则前一个元素后移
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            //找到待插入位置
            if (j != i) {
                array[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {35, 63, 48, 9, 86, 24, 53, 11};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
