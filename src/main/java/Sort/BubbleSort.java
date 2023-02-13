package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2023/02/03/20:48
 * @Description:
 */
public class BubbleSort {
    public static void sort(int[] arr) {
        //标记是否有交换
        boolean flag;
        for (int i = 0; i < arr.length; i++) {
            //初始默认为false
            flag = false;
            //遍历列表
            for (int j = 0; j < arr.length - i - 1; j++) {
                //如果后一个元素小于当前元素，则交换，并且标记flag为true
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j, j + 1);
                    flag = true;
                }

            }
            //如果当前遍历没有进行交换，说明已经排序完成
            if (!flag) return;

        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {35, 63, 48, 9, 86, 24, 53, 11};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
