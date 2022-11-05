package QueueAndStack;

import java.util.Deque;
import java.util.LinkedList;

public class Trap {
    public static int trap(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            //遇到比栈顶大的元素
            while (!deque.isEmpty() && height[i] > height[deque.peekLast()]) {
                int tmp = deque.pollLast();
                if (!deque.isEmpty()) {
                    //根据栈顶元素，弹栈出来的tmp，和遍历遇到的i，计算这一块的体积
                    res += (i - deque.peekLast() - 1) * (Math.min(height[i], height[deque.peekLast()]) - height[tmp]);
                }
            }
            deque.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}
