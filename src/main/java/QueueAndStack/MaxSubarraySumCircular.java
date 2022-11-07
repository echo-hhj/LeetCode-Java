package QueueAndStack;


public class MaxSubarraySumCircular {
    public static int maxSubarraySumCircular(int[] nums) {
        //total为数组的总和，maxSum为最大子数组和，minSum为最小子数组和，
        // curMax为包含当前元素的最大子数组和，curMin为包含当前元素的最小子数组和
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;

    }

    public static void main(String[] args) {
        int[] nums = {1, -2, 3, -2};
        System.out.println(maxSubarraySumCircular(nums));
    }
}
