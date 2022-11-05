package LinkedList;

public class intersectList {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //定义两个指针
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            // 当你走到终点时，开始走她走过的路
           p = p == null ? headB : p.next;
            // 当她走到终点时，开始走你走过的路
           q = q == null ? headA : q.next;

        }
        // 一路上，时而你踩着她的影子，时而她踩着你的影子。渐渐地，你变成了她，她也变成了你
        return p;
    }
}
