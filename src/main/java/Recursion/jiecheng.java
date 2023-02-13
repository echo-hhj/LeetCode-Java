package Recursion;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2023/02/05/20:03
 * @Description:
 */
public class jiecheng {
    public static int jiecheng(int n) {
        if (n == 0) return 1;
        return n * jiecheng(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(jiecheng(3));
    }
}
