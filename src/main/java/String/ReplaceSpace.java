package String;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/10/24/8:15
 * @Description:
 */
public class ReplaceSpace {
    public static String reverseStr(String s, int k) {
        //将字符串转成字符串数组
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2*k) {
            int left = i;
            int right = Math.min(i + k - 1, str.length - 1);
            //交换
            while (left < right) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                ++left;
                --right;
            }

        }
        return new String(str);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,2));
    }
}
