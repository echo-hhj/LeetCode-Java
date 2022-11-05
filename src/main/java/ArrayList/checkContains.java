package ArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/24/21:36
 * @Description:
 */
public class checkContains {
    public static void main(String[] args) {
        String s1= "abcdxabcde" , s2 = "abcdeabcdx";
        System.out.println(checkIncludes(s1, s2));

    }
    public static boolean checkIncludes(String s1, String s2) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();

        //遍历字符串1，将字符作为key，次数作为value
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c,0) + 1);
        }
        //设置窗口左右坐标
        int left = 0, right = 0;
        int count = 0;  //记录符合条件的字符个数
        //判断窗口停止右移条件
        while (right < s2.length()) {
            //记录即将加入窗口的字符
            char d = s2.charAt(right);
            //窗口右移
            right++;
            //判断加入的字符是否在s1中
            if (need.containsKey(d)) {
                window.put(d, window.getOrDefault(d,0) + 1);
                //如果窗口内字符满足要求
                if (window.get(d).equals(need.get(d))) {
                    count++;
                }
            }
            // System.out.println("window [" + left + "," + right + ")");
            //判断窗口收缩条件
            while (count == need.size()) {
                if (right - left == s1.length()) return true;
                //标记即将移出的窗口元素
                char ch = s2.charAt(left);
                //窗口收缩
                left++;
                //如果移出的字符刚好是是s1中的字符
                if (need.containsKey(ch)) {
                    //且字符数目刚好相等，移出之后不满足条件
                    if (need.get(ch).equals(window.get(ch))) {
                        count--;
                    }
                    window.put(ch, window.get(ch) - 1);
                }


            }

        }
        //如果循环完以后还没有找到则返回FALSE
        return false;
    }
}
