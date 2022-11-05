package String;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) return;
        //设置左右指针
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }
}
