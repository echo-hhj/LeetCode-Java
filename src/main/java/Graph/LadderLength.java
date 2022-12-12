package Graph;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/12/04/11:51
 * @Description:
 */
public class LadderLength {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.size() == 0 || !set.contains(endWord)) {
            return 0;
        }
        set.remove(beginWord);
        //存放已访问的字符串
        Set<String> visited = new HashSet<>();
        //存放字符串队列
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        //记录步数
        int step = 1;
        while (!queue.isEmpty()) {
            //获取当前队列的大小
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //取出单词
                String word = queue.poll();
                for (int j = 0; j < endWord.length(); j++) {
                    //对单词的每一位从a到z进行变换
                    char[] chars = word.toCharArray();
                    char originchar = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        //如果与原单词一致则跳过
                        if (k == originchar) continue;
                        chars[j] = k;
                        //获得变换后的单词
                        String curword = String.valueOf(chars);
                        //如果等于目标单词则返回
                        if (curword.equals(endWord)) return step + 1;
                        //如果单词列表有当前单词并且没有被访问过就加入队列和已访问集合
                        if (set.contains(curword)) {
                            if (!visited.contains(curword)) {
                                queue.add(curword);
                                visited.add(curword);
                            }
                        }
                        //将单词还原
                        // chars[j] = originchar;
                    }
                }
            }
            ++step;
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "ymain";
        String end = "oecij";
        List<String> arr = Arrays.asList("ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain");
        System.out.println(ladderLength(begin, end, arr));
    }
}
