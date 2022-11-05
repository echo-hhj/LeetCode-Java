package QueueAndStack;

import java.util.*;

public class NextGreaterElements {
    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        //使用Arrays内置的fill方法附初值
        Arrays.fill(res, -1);
        //定义栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
