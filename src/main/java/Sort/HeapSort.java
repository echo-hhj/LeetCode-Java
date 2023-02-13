package Sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/20/11:09
 * @Description:
 */
public class HeapSort {
    //调整大根堆
    public static int[] adjustHeap(int[] arr, int len, int index) {
        int left = index * 2 + 1;   //左节点下标
        int right = index * 2 + 2;  //右节点下标
        int maxIndex = index;     //标记最大值下标
        //寻找最大值下标
        if (left < len && arr[left] > arr[maxIndex]) {
            maxIndex = left;    //如果左节点的值比父节点的值要大则标记左节点下标
        }
        if (right < len && arr[right] > arr[maxIndex]) {
            maxIndex = right;   //如果右节点的值比最大值要大则标记右节点下标
        }
        //如果最大值下标与当前下标不相等
        if (maxIndex != index) {
            //交换父节点与最大值的节点的值
            swap(arr, maxIndex, index);
            //递归调整
            adjustHeap(arr, len, maxIndex);

        }
        return arr;
    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2)
            return arr;

        int len = arr.length;
        //大根堆的构建是从最后一个非叶子节点开始，从下往上，从右往左调整
        //最后一个非叶子节点的位置为：array.length/2 - 1
        for (int i = len / 2 - 1; i >= 0; i--) {
            //调整使之成为大根堆
            adjustHeap(arr, len, i);
        }
        //排序
        for (int i = len - 1; i >= 0; i--) {
            //交换堆顶和当前下标元素，当前最大值已被放到末尾
            swap(arr, i, 0);
            //调整大根堆，因为已排序一个，故再排序时数组长度减一
            adjustHeap(arr, i, 0);
        }
        return arr;
    }

    private static void swap(int[] arr, int maxIndex, int index) {
        int temp = arr[maxIndex];
        arr[maxIndex] = arr[index];
        arr[index] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {35, 63, 48, 9, 86, 24, 53, 11};
        System.out.println(Arrays.toString(arr));
        System.out.println("============================================");
        System.out.println(Arrays.toString(sort(arr)));
    }
}
