package HashList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/20/7:37
 * @Description:
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
        //如果字符串长度不相等则返回FALSE
        int slen = s.length();
        int tlen = t.length();
        if (slen != tlen) return false;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < slen; i++) {
            //如果map中key不包含s的字符
            if (!map.containsKey(s.charAt(i))) {
                //但value中有对应的t中字符，说明映射不唯一
                if (map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }

            } else {
                //包含对应key的时候，验证是否相等
                if (!map.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            }

        }
        return true;
    }
}
