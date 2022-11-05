package ArrayList;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/23/15:03
 * @Description:
 */
public class DemoAdd {
    public static void main(String[] args) {
        int[] s = {9,9,9};
        System.out.println(Arrays.toString(plusOne(s)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            //从后到前元素加1
            digits[i]++;
            //当前位置的数值为加1后模10
            digits[i] %= 10;
            //如果取余的值不为0，说明没有产生进位，直接返回数组
            if (digits[i] != 0) {
                return digits;
            }
        }
        //如果上面的循环执行完了还没有返回，说明数组都产生了进位
        //故数组里现在全是0，最高位数字存放在数组的首位
        digits = new int[digits.length + 1];
        //将数组下标为0的数值置为1
        digits[0] = 1;
        return digits;

    }
}
