package HashList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/21/16:34
 * @Description:
 */
public class fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //遍历第一个和第二个数组
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int temp = num1 + num2;
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        //遍历第三个和第四个数组
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int temp = num3 + num4;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}