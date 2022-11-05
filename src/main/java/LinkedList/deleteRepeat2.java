package LinkedList;

 public class deleteRepeat2 {
     public static void main(String[] args) {
         ListNode l1 = new ListNode(2);
         l1.next = new ListNode(4);
         l1.next.next = new ListNode(6);
         System.out.println(middleNode(l1).val);
     }
     public static ListNode middleNode(ListNode head) {
        //  //新建虚拟头结点
        // ListNode dummy = new ListNode(-1, head);
        //设置快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            //慢指针走一步
            slow = slow.next;
            //快指针走两步
            fast = fast.next.next;
        }
        // //如果遍历完快指针不为空说明节点个数为偶数
        // if (fast != null) slow = slow.next;
        //返回中间节点
        return slow;
     }
}