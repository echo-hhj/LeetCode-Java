package ArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/25/8:36
 * @Description:
 */
public class distinctLongestSubstring {
    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character,Integer> window = new HashMap<>();

        int max = Integer.MIN_VALUE;    //记录最长子串的长度
        int left = 0, right = 0;    //标记窗口的左右位置
        while (right < s.length()) {
            //记录即将加入窗口的元素
            char c = s.charAt(right);
            right++;
            //如果加入的元素已经包含在窗口内
            window.put(c, window.getOrDefault(c, 0) + 1);
            // System.out.println("window [" + left + "," + right + ")  " + len);
            //判断窗口收缩条件
            while (window.get(c) > 1) {
                //记录即将移出的元素
                char d = s.charAt(left);
                left++;
                //将该字符出现次数减一
                window.put(d, window.get(d) - 1);
            }
            //如果窗口内没有重复元素
            max = Math.max(right - left, max);

        }
        return max;
    }
}
