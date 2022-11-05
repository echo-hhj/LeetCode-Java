package LinkedList;

public class cycle {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = l1;
        System.out.println(hasCycle(l1));
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return  false;
        //设置快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //如果快指针能追上慢指针，说明有环
            if (slow == fast) return true;
        }
        return false;
    }
}
