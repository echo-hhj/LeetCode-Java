package TreeAndHeap.BasicTraversal;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //新建一个队列用来存储层序遍历的元素
        Deque<TreeNode> qe = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        //将根节点放入队列中
        qe.add(root);

        while (!qe.isEmpty()) {
            //标记队列的大小，也就是当前这一层的元素个数
            int size = qe.size();
            //存放当前层的元素
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //取出队头元素，加入列表
                TreeNode node = qe.poll();
                temp.add(node.val);
                //如果当前节点的左右子节点不为空则加入队列
                if (node.left != null) qe.add(node.left);
                if (node.right != null) qe.add(node.right);
            }
            //将这一层的元素加入结果列表中
            res.add(temp);
        }
        return res;
    }
}
