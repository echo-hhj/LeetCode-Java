package TreeAndHeap.SearchTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        //初始化上一个节点与当前节点
        TreeNode pre = null;
        TreeNode cur = root;
        //标记最小值
        int res = Integer.MAX_VALUE;
        while (cur != null || !dq.isEmpty()) {
            //中序遍历
            if (cur != null) {
                dq.push(cur);
                cur = cur.left;
            } else {
                //节点为空则出栈
                cur = dq.pop();
                //比较
                if (pre != null) res = Math.min(res, Math.abs(cur.val - pre.val));
                pre = cur;
                cur = cur.right;
            }
        }
        return res;
    }
}
