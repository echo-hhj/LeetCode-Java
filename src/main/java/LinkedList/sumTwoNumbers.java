package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/09/28/8:03
 * @Description:
 */
public class sumTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2 .next =new ListNode(6);
        ListNode p = addTwoNumbers(l1, l2);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //新建一个虚拟节点
        ListNode pre = new ListNode(-1);
        //指向当前节点
        ListNode cur = pre;
        //记录是否有进位
        int carry = 0;
        //记录两数之和
        int sum = 0;
        //当两个节点有一个不为空的时候
        while (l1 != null || l2 != null) {
            //当节点不为空的时候取得该节点的值，否则置为1
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            sum = a + b + carry; //记录相加
            carry = sum / 10; //记录进位
            cur.next = new ListNode(sum % 10); //将求和数赋值给新链表的节点

            cur = cur.next;//指向下一个节点

            //当链表l1不等于null的时候，将l1 的节点后移
            if(l1 !=null){
                l1 = l1.next;
            }
            //当链表l2 不等于null的时候，将l2的节点后移
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        //如果遍历完成进位为1，说明还得再加一个节点
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        //返回头结点
        return  pre.next;


    }

}
