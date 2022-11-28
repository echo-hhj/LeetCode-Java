package HashList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        //分别遍历两个数组
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
