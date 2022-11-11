package TreeAndHeap.BasicTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/11/7:46
 * @Description:
 */
public class AverageOfLevels {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        //记录层的总和
        double sumLevel;
        TreeNode cur = null;
        while (!dq.isEmpty()) {
            int size = dq.size();
            sumLevel = 0;
            for (int i = 0; i < size; i++) {
                cur = dq.poll();
                //将同一层的节点值相加
                sumLevel += cur.val;
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
            res.add(sumLevel/size);
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(averageOfLevels(root));
    }
}
