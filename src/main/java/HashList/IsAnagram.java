package HashList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/20/7:58
 * @Description:
 */
public class IsAnagram {
    public static boolean isAnagram(String s, String t){
        //如果长度不相等
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            char c = t.charAt(i);
            if (map.getOrDefault(c, 0) <= 0) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagram(s, t));
    }
}
