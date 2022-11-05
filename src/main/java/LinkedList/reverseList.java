package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/28/9:42
 * @Description:
 */
public class reverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        l1.next.next.next = new ListNode(6);
        ListNode p = reverseBetween(l1,2,3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        //新建虚拟头节点
        ListNode dummy = new ListNode(-1);;
        dummy.next = head;
        ListNode prev = dummy;
        //找到left的前一个节点
        for (int i = 0; i < left - 1; ++i) {
            prev = prev.next;
        }

        ListNode cur = prev.next;

        int num = right - left;     //需要翻转的节点数
        while (num > 0) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
            --num;

        }
        return dummy.next;
    }
}
