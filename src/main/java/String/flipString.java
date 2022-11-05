package String;

public class flipString {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(trans(str,11));
    }

    public static String trans(String s, int n) {
        if (n == 0)
            return s;
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < n; i++) {
            //大小写转换
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                res.append((char)(s.charAt(i) - 'A' + 'a'));
            } else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                res.append((char)(s.charAt(i) - 'a' + 'A'));
            } else {
                res.append(s.charAt(i));
            }
        }
        //翻转所有字符串
        res = res.reverse();
        for (int i = 0; i < n; i++) {
            //寻找空格隔开的单词
            int j = i;
            while (j < n && s.charAt(j) != ' ') ++j;
            String temp = res.substring(i,j);
            StringBuffer buffer = new StringBuffer(temp);
            res.replace(i, j, buffer.reverse().toString());
            i = j;
        }
        return String.valueOf(res);
    }
}
