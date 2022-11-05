package ArrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/24/16:41
 * @Description:
 */
public class mergeArrays {
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            //标记数组1和数组2中下标位置
            int len1 = m - 1;
            int len2 = n - 1;
            //合并后的数组下标位置
            int index = m + n - 1;
            //为避免nums1中数据被覆盖，从后往前遍历
            //当其中有数组遍历完成时退出循环
            while (len1 >= 0 && len2 >= 0) {
                //如果数组nums1中元素大于nums2中元素则nums1加入数组末尾
                if (nums1[len1] > nums2[len2]) {
                    nums1[index--] = nums1[len1--];
                } else {
                    //否则将nums2中元素加入数组末尾
                    nums1[index--] = nums2[len2--];
                }
            }
            //如果数组2还未遍历完，将剩下的元素加入数组1中
            if (len2 > -1) {
                for (int i = 0; i <= len2; i++) {
                    nums1[i] = nums2[i];

            }
        }
    }
}
