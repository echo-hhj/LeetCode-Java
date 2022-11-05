package LinkedList;

public class deleteRepeat {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(6);
        ListNode p = deleteDuplicates(l1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        //标记前驱与当前节点
        ListNode pre = head;
        ListNode cur = head.next;
        //当前节点不为空进行比较
        while (cur != null) {
            if (cur.val != pre.val) {
                pre = pre.next;
            }
            cur = cur.next;
            pre.next = cur;
        }
        return head;
    }
}
