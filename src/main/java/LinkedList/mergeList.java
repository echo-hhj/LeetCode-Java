package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/10/12/10:32
 * @Description:
 */
public class mergeList {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        //新建虚拟头结点
        ListNode cur = dummy;
        //当列表12都没有遍历完的时候
        while (list1 != null && list2 != null) {
            //将小的节点链在当前节点后面。同时将当前节点向后移一位
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        //当列表1没有遍历完的时候
        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        //当列表2没有遍历完的时候
        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}