package TreeAndHeap.BasicTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        //用队列来存储节点
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //获取当前层的节点个数
            int size = dq.size();
            while (size-- != 0) {
                Node cur = dq.poll();
                level.add(cur.val);
                //遍历当前节点的孩子节点并加入队列
                for (Node node : cur.children) {
                    dq.offer(node);
                }
            }
            res.add(level);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}