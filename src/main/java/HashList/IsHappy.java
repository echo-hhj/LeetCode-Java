package HashList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/20/8:25
 * @Description:
 */
public class IsHappy {
    public boolean isHappy(int n) {
        //利用哈希表去重的特性
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextnumber(n);
        }
        return n == 1;
    }
    //获取下一个数
    private int getNextnumber(int n) {
        int sum = 0;
        int temp;
        while (n != 0) {
            temp = n % 10;
            sum += Math.pow(temp, 2);
            n = n/10;
        }
        return sum;
    }
}
