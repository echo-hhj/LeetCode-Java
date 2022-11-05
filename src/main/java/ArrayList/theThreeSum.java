package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/26/9:48
 * @Description:
 */
public class theThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //将数组从小到大排序
        Arrays.sort(nums);
        int left, right;
        int sum; //记录三数之和
        //遍历数组中的元素
        for (int i = 0; i < nums.length - 2; i++) {
            //设置窗口的左右边界
            left = i + 1;
            right = nums.length - 1;
            //当前元素大于0的时候直接返回
            if (nums[i] > 0) return result;
            //当前元素与上一个相等，跳出当前循环
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                //判断三数之和与0的大小关系
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //当有重复的元素出现时跳过
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;

                }
            }
        }
        return  result;
    }
}
