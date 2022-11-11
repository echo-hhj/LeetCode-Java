package TreeAndHeap.BasicTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/10/17:04
 * @Description:
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while (!dq.isEmpty()) {
            int size = dq.size();
            //初始化当前层的最大值
            int max = Integer.MIN_VALUE;
            while (size-- != 0) {
                TreeNode cur = dq.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
