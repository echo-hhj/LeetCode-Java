package ArrayList;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/26/7:58
 * @Description:
 */
public class findAgain {
    public static void main(String[] args) {
        String  s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();

        //将目标字符串中的字符遍历加入map
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;//记录满足条件的字符个数
        while (right < s.length()) {
            //即将加入窗口的字符
            char d = s.charAt(right);
            //窗口右移
            right++;
            //如果加入的字符在p中
            if (need.containsKey(d)) {
                window.put(d, window.getOrDefault(d,0) + 1);
                //判断加入的字符是否符合条件
                if (need.get(d).equals(window.get(d))) {
                    count++;

                }

            }
            //窗口收缩的条件
            while (count == need.size()) {
                //如果长度正好
                if (right - left == p.length()) {
                    list.add(left);     //将坐标加入结果
                }
                //即将移出窗口的元素
                char c = s.charAt(left);
                left++;
                if (need.containsKey(c)) {
                    if (need.get(c).equals(window.get(c)))  count--;
                    window.put(c, window.get(c) - 1);
                }
            }
        }
        return list;
    }
}
