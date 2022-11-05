package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindSubstring {
    public static List<Integer> findSubstring(String s, String[] words) {
        //创建返回结果
        List<Integer> res = new ArrayList<>();
        //记录单词出现次数
        HashMap<String,Integer> allWords = new HashMap<>();
        for (String word : words) {
            allWords.put(word, allWords.getOrDefault(word,0) + 1);
        }
        //单词长度
        int wordLength = words[0].length();
        //单词个数
        int wordNum = words.length;
        for (int i = 0; i < s.length() - wordLength*wordNum + 1; i++) {
            int index = i;
            //记录当前窗口出现单词
            HashMap<String,Integer> window = new HashMap<>();
            while (index < i + wordLength*wordNum) {
                String curWord = s.substring(index, index + wordLength);
                //判断单词是否满足要求
                if (!allWords.containsKey(curWord) || window.getOrDefault(curWord,0).equals(allWords.get(curWord))) {
                    break;
                }
                window.put(curWord,window.getOrDefault(curWord,0) + 1);
                index += wordLength;
                if (index == i + wordLength*wordNum) {
                    res.add(i);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstring(s, words));
    }
}