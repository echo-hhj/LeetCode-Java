package TreeAndHeap.Heap;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/18/8:34
 * @Description:
 */
public class TopKFrequent {
    public static List<String> topKFrequent(String[] words, int k) {
        //结果
        List<String> res = new ArrayList<>();
        //统计单词出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        //新建最小堆并定义规则
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) {
                    return o1.compareTo(o2);
                }
                return map.get(o2) - map.get(o1);
            }
        });
        for (String key : map.keySet()) {
            heap.add(key);
        }
        //将堆中元素加入结果
        while (k-- != 0) {
            res.add(heap.poll());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(str, 4));
    }
}
