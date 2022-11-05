package LinkedList;

public class getFromBottom {
    public static void main(String[] args) {

    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        //设置快慢指针
        ListNode slow = head;
        ListNode fast = head;
        //fast先走k步
        int cnt = 1;
        while (cnt < k) {
            fast = fast.next;
            ++cnt;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
