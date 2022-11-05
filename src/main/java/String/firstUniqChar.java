package String;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {
    public static int firstUniqChar(String s) {
        //新建哈希表
        Map<Character,Integer> map = new HashMap<>();
        //获取字符串的字符数组
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            //字符每出现一次加1
            map.put(ch[i], map.getOrDefault(ch[i],0) + 1);
        }
        for (int i = 0; i < ch.length; i++) {
            if (map.get(ch[i]) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));
    }
}
