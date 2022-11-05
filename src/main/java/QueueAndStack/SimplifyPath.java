package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        //分割字符串
        String[] names = path.split("/");
        for (String name : names) {
            //返回上级目录
            if (name.equals("..")) {
                if(!stack.isEmpty())
                    stack.pollLast();
            } else {
                //排除掉当前路径和空字符
                if (!name.equals(".") && name.length() > 0) {
                    stack.offerLast(name);
                }
            }
        }
        //如果栈为空直接返回
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }
}
