package HashList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //先对数组进行排序
        Arrays.sort(nums);
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //如果当前元素大于0并且大于目标值，说明后面的也不可能
            if (nums[i] > 0 && nums[i] > target) {
                return res;
            }
            //如果当前元素与上一个元素相同继续
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //j从i+1开始
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                //设置左右指针
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //记录四数之和
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        --right;
                    } else if (sum < target) {
                        ++left;
                    } else {
                        //等于目标值加入结果
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //下一个元素与当前相等则跳过
                        while (left < right && nums[left] == nums[left + 1]) ++left;
                        while (left < right && nums[right] == nums[right - 1]) --right;
                        ++left;
                        --right;
                    }
                }
            }
        }
        return res;
    }
}
