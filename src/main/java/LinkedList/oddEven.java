package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/10/18/9:06
 * @Description:
 */
public class oddEven {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode p = oddEvenList(l1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        //设置奇偶指针
        ListNode odd = head;
        ListNode even = head.next;
        //设置虚拟节点指向偶指针
        ListNode dummy = new ListNode();
        dummy.next = even;
        //设置奇偶两条链
        while (even != null && even.next!= null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        //将奇偶两条链连接在一起
        odd.next = dummy.next;
        return head;
    }
}
