package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/12/10:03
 * @Description:
 */
public class QuickSort {
    public static int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        return quickSort(arr, 0, sourceArray.length - 1);
    }

    private static int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        //定义基准位置
        int pivot = left;
        //将比基准元素小的放到前面，比基准元素大的放在后面
        while (left < right) {
            while (left < right && arr[left] < arr[pivot]) ++left;
            while (left < right && arr[right] > arr[pivot]) --right;
            swap(arr, left, right);
        }
        //将基准元素
        swap(arr, left, pivot);
        return left;
    }

    // 交换元素
    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {20, 413, 3, 53, 90, 324};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
