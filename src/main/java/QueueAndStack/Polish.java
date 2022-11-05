package QueueAndStack;

import java.util.Stack;

public class Polish {
    public int evalRPN(String[] tokens) {
        //存储数字
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            //如果是操作符就取出两个数运算结果入栈
            if (isOperator(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                if (s.equals("+")) {
                    stack.push(temp2 + temp1);
                } else if (s.equals("-")) {
                    stack.push(temp2 - temp1);
                }else if (s.equals("*")) {
                    stack.push(temp2 * temp1);
                }else{
                    stack.push(temp2 / temp1);
                }
            } else {
                //不是则把操作数入栈
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    //判断是否是操作符
    public boolean isOperator(String op) {
        if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) return true;
        return false;
    }
}
