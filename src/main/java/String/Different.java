package String;

public class Different {
    public static boolean checkDifferent(String iniString) {
        if (iniString.length() > 256) {
            return false;
        }

        boolean[] char_set = new boolean[256];
        for (int i = 0; i < iniString.length(); i++) {
            char val = iniString.charAt(i);
            if (char_set[val])
                return false;
            char_set[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aeiou";
        System.out.println(checkDifferent(s));
    }
}
