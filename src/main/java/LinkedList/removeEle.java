package LinkedList;


public class removeEle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode p = removeElements(l1,4);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        //新建虚拟头结点
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        dummy.next = head;
        //当前节点不为空的时候
        while (head != null) {
            //如果当前值不等于目标值，前驱向后移动
            if (head.val != val) {
                pre = pre.next;
            }
            head = head.next;
            pre.next = head;
        }
        return dummy.next;
    }
}
