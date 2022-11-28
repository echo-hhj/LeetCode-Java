package HashList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/21/16:23
 * @Description:
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        //遍历magazine
        for (char c : magazine.toCharArray()) {
            map.put(c , map.getOrDefault(c, 0) + 1);
        }
        //遍历所写字符串
        for (char c : ransomNote.toCharArray()) {
            if (map.getOrDefault(c, 0) <= 0) return false;
            map.put(c , map.get(c) - 1);
        }
        return true;
    }
}