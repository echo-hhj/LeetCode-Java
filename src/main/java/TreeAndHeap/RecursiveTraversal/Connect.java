package TreeAndHeap.RecursiveTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/14/8:16
 * @Description:
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        Node cur;
        while (!dq.isEmpty()) {
            //记录每层的节点数
            int size = dq.size();
            //留下每一层的最后一个节点
            while (size-- != 1) {
                cur = dq.poll();
                cur.next = dq.peek();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);

            }
            //对每层最后一个节点单独处理
            cur = dq.poll();
            cur.next = null;
            if (cur.left != null) dq.offer(cur.left);
            if (cur.right != null) dq.offer(cur.right);
        }
        return root;
    }
}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};