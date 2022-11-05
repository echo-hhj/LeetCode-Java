package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyStack() {
        //初始化队列
        queue1 = new LinkedList<>(); // 辅助队列
        queue2 = new LinkedList<>(); // 和栈中保持一样元素的队列
    }

    public void push(int x) {
        if (queue2.isEmpty()) {
            queue2.offer(x);
        } else {
            //辅助队列添加元素
            queue1.offer(x);
            //如果queue2队列中元素不为空全部添加到辅助队列queue1中
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            // 交换queue1和queue2，将元素都放到queue2
            Queue<Integer> queueTemp;
            queueTemp = queue2;
            queue2 = queue1;
            queue1 = queueTemp;
        }
    }

    public int pop() {
        return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        //入栈元素
        myStack.push(1);
        myStack.push(2);
        //返回栈顶元素
        System.out.println(myStack.top());
        //删除栈顶元素
        System.out.println(myStack.pop());
        //判断是否为空
        System.out.println(myStack.empty());

    }
}