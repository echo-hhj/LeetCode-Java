package QueueAndStack;

import java.util.Stack;

public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //获取字符
            char ch = s.charAt(i);
            //如果是左括号把相应右括号加入栈，方便对比
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
                //如果栈为空或者右括号与栈顶元素不相等返回FALSE
            } else if (stack.isEmpty() || ch != stack.pop()){
                return false;
            }
        }
        //运行完以后栈内还有元素返回FALSE
        if (!stack.isEmpty()) return false;
        return true;
    }
}
