package Recursion;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2023/02/05/20:29
 * @Description:
 */
public class JudgeOrder {

    public static boolean IsOrd(int[] array, int len) {
        if (len == 1) return true;
        if (array[len - 1] < array[len - 2]) return false;
        return IsOrd(array, len - 1);
    }

    public static void main(String[] args) {
        int[] arr = {35, 63, 48, 9, 86, 24, 53, 11};
        System.out.println(IsOrd(arr, arr.length));
    }
}
