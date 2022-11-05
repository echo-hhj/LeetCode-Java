package String;

public class ReverseWords {
    public static String reverseWords(String s) {
        //转换字符串
        char[] ch = s.toCharArray();

            int left = 0;
            int right = 0;
            int length = ch.length;
            while (right <= length){
            if ( right == length || ch[right] == ' ') {
                int end = right - 1;
                //翻转单词
                while (left < end) {
                    char temp = ch[left];
                    ch[left] = ch[end];
                    ch[end] = temp;
                    ++left;
                    --end;
                }
                left = right + 1;
            }
            ++right;
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
