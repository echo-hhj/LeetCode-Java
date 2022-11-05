package String;

import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        //存储结果
        int[] res = new int[2];
        //设置左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            //大于目标值则右指针向左移动
            if (sum > target) {
                --right;
            } else if (sum < target) {
                ++left;
            } else {
                //等于目标值则加入结果
                res[0] = nums[left];
                res[1] = nums[right];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums,target)));
    }
}
