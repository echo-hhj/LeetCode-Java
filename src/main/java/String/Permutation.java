package String;

import java.util.*;

public class Permutation{

    public static String[] Permutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        //判断字符串是否为空
        if(s == null || s.length() == 0) {
            return result.toArray(new String[result.size()]);
        }
        //获取字符串的字符数组
        char[] ch = s.toCharArray();
        //利用TreeSet没有重复元素的特点，去除重复的排列
        TreeSet<String> treeSet = new TreeSet<>();
        Quchong(ch, 0, treeSet);
        result.addAll(treeSet);
        return result.toArray(new String[result.size()]);
    }

    public static void Quchong(char[] ch, int begin, TreeSet<String> treeSet){
        if(begin == ch.length-1){
            //排序
            treeSet.add(String.valueOf(ch));
        }else{
            for(int i = begin ; i <= ch.length-1; i++) {
                //拿第一个字符和它后面的字符逐个交换
                swap(ch, begin, i);
                //begin加一进行重新传值
                Quchong(ch, begin+1, treeSet);
                // 换回来，为了下一次和其它字符交换
                swap(ch, begin, i);
            }
        }
    }
    //交换位置
    public static void swap(char[] str, int i, int j){
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    // 测试
    public static void main(String[] args) {
        String str = "abb";
        System.out.println(Arrays.toString(Permutation(str)));
    }
}