package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/28/9:09
 * @Description:
 */
public class reverseLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode p = reverseList(l1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        //新建一个虚拟头结点
        ListNode dummy = new ListNode(-1);
        //新建当前节点
        ListNode cur = head;
        //记录前一个节点
        ListNode pre = null;
        //记录后一个节点
        ListNode temp = null;

        //头插法
        while (cur != null) {
            temp = cur.next;
            dummy.next = cur;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return dummy.next;
    }
}
