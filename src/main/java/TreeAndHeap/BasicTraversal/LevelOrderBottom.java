package TreeAndHeap.BasicTraversal;

import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //关键：使用LinkedList存储结果
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        //使用队列来存储节点
        Deque<TreeNode> dqueue = new ArrayDeque<>();
        dqueue.offer(root);
        TreeNode cur;
        //栈不为空
        while (!dqueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            //获取这一层的节点数量
            int size = dqueue.size();
            while (size-- != 0) {
                //将当前节点的值加入当前层的列表
                cur = dqueue.poll();
                level.add(cur.val);
                //如果当前节点的左右孩子不为空则入栈
                if (cur.left != null) dqueue.offer(cur.left);
                if (cur.right != null) dqueue.offer(cur.right);

            }
            //！！！重点
            res.addFirst(level);
        }
        return res;
    }
}
