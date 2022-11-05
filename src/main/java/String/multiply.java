package String;

public class multiply {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        //两数相乘最大位数为两数长度之和
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                //从个位数开始记录乘积
                int sum = a * b + res[i + j + 1];
                //乘积的余数放在高位
                res[i + j] += sum / 10;
                res[i + j + 1] = sum % 10;
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < res.length; i++ ) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }
}
