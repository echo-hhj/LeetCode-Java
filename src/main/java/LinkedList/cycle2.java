package LinkedList;

public class cycle2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = l1;
        System.out.println(detectCycle(l1).val);

    }
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        //设置快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            //如果为空说明无环
            if (fast == null || fast.next == null) return null;
            //快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            //相等则有环，退出循环
            if (slow == fast) break;
        }
        //快指针从头开始
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
