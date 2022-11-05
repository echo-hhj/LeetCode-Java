package Daily;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/02/20:18
 * @Description:
 */
public class ArrayStringsAreEqual {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (String word : word1)
            sb1.append(word);
        for (String word : word2)
            sb2.append(word);
        if (sb1.toString().equals(sb2.toString())) return true;
        return false;
    }
}
