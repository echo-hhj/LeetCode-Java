package ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/23/15:47
 * @Description:
 */
public class twoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    public static int[] twoSum(int[] nums, int target) {
        //新建一个hashmap用来存储数据
        Map<Integer, Integer> map = new HashMap<>();
        //用来保存结果
        int[] res = new int[2];
        //遍历数组中的元素，将值作为key，下标作为value
        for (int i = 0; i < nums.length; i++) {
            //如果另外一个数存在于map中，则将当前下标与另一个数的下标返回
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return  res;
            } else {
                //否则就将当前数组元素的值和下标加入map
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
