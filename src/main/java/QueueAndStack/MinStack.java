package QueueAndStack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;   //负责存储元素
    Stack<Integer> min;     //辅助存储最小元素
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        //如果辅助栈为空或者栈顶元素不小于当前入栈元素，则将元素加入辅助栈
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }

    public void pop() {
        int temp = stack.pop();
        //出栈元素不是最小元素则忽略。否则一同出栈
        if (temp == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }
    //辅助栈的栈顶元素就是当前栈内所有元素的最小值
    public int getMin() {
        return min.peek();
    }
}
