package ArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/24/20:02
 * @Description:
 */
public class slideWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        //模板
        /* 滑动窗口算法框架 */

            Map<Character, Integer> need = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            for (char c : t.toCharArray())
                need.put(c,need.getOrDefault(c,0)+1);
            int left = 0, right = 0;
            int valid = 0;
            int count = 0;  //标记窗口内满足t中字符的个数
            int start = 0;  //记录最小字符串开始的位置
            int len = Integer.MAX_VALUE;//记录最小字符串的长度
            while (right < s.length()) {
                // c 是将移入窗口的字符
                char c = s.charAt(right);
                // 右移窗口
                right++;
                // 进行窗口内数据的一系列更新
                //如果字符串t内包含该字符则进行更新
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c,0) + 1);
                    //如果窗口内字符的数量等于t内字符的数量，count++
                    if (need.get(c).equals(window.get(c))) {
                        count++;
                    }
                }

                /*** debug 输出的位置 ***/
               // System.out.println("window: ["+left+","+ right+")");
                /********************/

                // 判断左侧窗口是否要收缩
                //已经满足包含的字串
                while (count == need.size()) {
                    //如果当前窗口比之前小
                    if (right - left < len) {
                        //将最小字符串改为当前窗口的长度，并记录起始位置
                        len = right - left;
                        start = left;
                    }
                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    //如果移除的字符串是在need内的
                    if (need.containsKey(d)) {
                        //判断移出的字符串移出之后是否就不满足条件了
                        if (window.get(d).equals(need.get(d))) {
                            count--;
                        }
                        //将对应字符次数减一
                        window.put(d, window.get(d) - 1);
                    }

            }
        }
            //如果len没有改变说明不包含该字符串t
            return len == Integer.MAX_VALUE?"":s.substring(start,start + len);
    }
}
