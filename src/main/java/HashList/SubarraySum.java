package HashList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        //前缀和
        Map<Integer, Integer> preSum = new HashMap<>();
        //一开始的情况，下标 0 之前没有元素，可以认为前缀和为 0，个数为 1 个
        //为了计算当前元素如果等于k的情况
        preSum.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            //前面数字之和加上这个数字正好等于K,则累积
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num =  {1, 2, 1, 2, 1};
        System.out.println(subarraySum(num,3));
    }
}
