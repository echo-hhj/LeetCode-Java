package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/25/9:05
 * @Description:
 */
public class MergeSort {
    public static int[] mergeSort(int[] array, int left, int right) {
        //当left == right时只有一个元素，本身就是有序的，无须再划分，只需要归并
        if (left < right) {
            //划分的中间点
            int mid = (left + right) / 2;
            //递归划分左半区
            mergeSort(array, left, mid);
            //递归划分右半区
            mergeSort(array, mid + 1, right);
            //合并已排序的部分
            merge(array, left, mid, right);
        }
        return array;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        //标记左半区第一个未排序的元素 和 左半区结束位置
        int l_start = left;
        int l_end = mid;
        //标记右半区第一个未排序的元素 和 右半区结束位置
        int r_start = mid + 1;
        int r_end = right;
        //创建临时数组存储排序元素
        int[] temp = new int[right - left + 1];
        //临时数组元素下标
        int pos = 0;
        //合并
        while (l_start <= l_end && r_start <= r_end) {
            //将左右半区元素更小的排在前面
            if (array[l_start] < array[r_start]) {
                temp[pos++] = array[l_start++];
            } else {
                temp[pos++] = array[r_start++];
            }
        }
        //如果排完之后左半区还有剩余元素则直接加入临时数组当中
        while (l_start <= l_end) {
            temp[pos++] = array[l_start++];
        }
        //同上合并右半区剩余元素
        while (r_start <= r_end) {
            temp[pos++] = array[r_start++];
        }
        //把临时数组中的元素复制到原来的数组当中
        for (int i = 0; i < temp.length; i++) {
            array[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 8, 0, 5, 7, 1, 3, 9};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
    }
}
