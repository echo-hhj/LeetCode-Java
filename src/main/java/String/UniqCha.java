package String;

import java.util.HashMap;
import java.util.Map;

public class UniqCha {
    public static char firstUniqChar(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, !map.containsKey(ch));
        }

        // for (Map.Entry<Character,Integer> entry : map.entrySet()) {
        //     if (entry.getValue() == 1) return entry.getKey();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) ) return ch;
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }
}
