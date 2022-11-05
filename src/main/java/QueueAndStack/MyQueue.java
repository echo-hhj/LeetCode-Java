package QueueAndStack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stackIn;     //输入栈
    Stack<Integer> stackOut;    //输出栈

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        //如果输出栈为空将输入栈的数据依次push进输出栈
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        //如果输出栈不为空直接pop
        return stackOut.pop();
    }
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }
    public Boolean empty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        //入栈
        myQueue.push(1);
        myQueue.push(2);
        //三个方法输出
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}