package LinkedList;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/10/14/9:29
 * @Description:
 */
public class huiwen {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(2);
        System.out.println(isPalindrome(l1));
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next ==null) return true;
        //新建数组
        ArrayList<Integer> arr = new ArrayList<>();
        //将链表中的元素加入到数组中
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        //设置两个下标分别冲头和尾向中间遍历
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            if (!Objects.equals(arr.get(i), arr.get(j)))
                return false;
            ++i;
            --j;
        }
        return true;
    }
}
