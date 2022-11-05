package String;

import java.util.HashMap;
import java.util.Map;

public class countCharacters {
    public static int countCharacters(String[] words, String chars) {
        Map<Character,Integer> need = count(chars);
        //记录能表达的所有单词的长度之和
        int num = 0;
        //遍历字符数组中的字符串
        for (String str : words) {
            Map<Character,Integer> word = count(str);
            int len = word.size();
            for (Character ch : word.keySet()) {
                if (need.containsKey(ch)) {
                    if (word.get(ch) <= need.get(ch)) {
                        --len;
                    } else break;
                }else break;
                if (len == 0)
                    num += str.length();
            }
        }

        return num;

    }
    public static Map<Character,Integer> count(String s) {
        Map<Character,Integer> need = new HashMap<>();
        //记录字符出现次数
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            need.put(temp, need.getOrDefault(temp,0) + 1);
        }
        return need;
    }

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words,chars));
    }
}
