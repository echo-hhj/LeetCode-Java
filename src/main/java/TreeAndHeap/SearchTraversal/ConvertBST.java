package TreeAndHeap.SearchTraversal;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/17/8:43
 * @Description:
 */
public class ConvertBST {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> dq = new ArrayDeque<>();
        //当前节点
        TreeNode cur = root;
        //大于当前节点的总和
        int sum = 0;
        while (cur != null || !dq.isEmpty()) {
            if (cur != null) {
                //按右 根 左 遍历
                dq.push(cur);
                cur = cur.right;
            } else {
                cur = dq.pop();
                sum += cur.val;
                cur.val = sum;
                cur = cur.left;
            }
        }
        return root;
    }
}