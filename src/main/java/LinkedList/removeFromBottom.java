package LinkedList;


public class removeFromBottom {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode p = removeNthFromEnd(l1,3);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //设置虚拟节点
        ListNode dummy = new ListNode(-1, head);
        //设置快慢指针
        ListNode slow = dummy;
        ListNode fast = dummy;
        //快指针先走n+1个节点
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //快慢指针一起走
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //此时slow指向n的前驱，删除倒数第n个节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
