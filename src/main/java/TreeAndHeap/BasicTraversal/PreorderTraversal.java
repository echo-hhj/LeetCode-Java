package TreeAndHeap.BasicTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/07/15:24
 * @Description:
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //存放结果
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        //当前节点
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            while (cur != null) {
                res.add(cur.val);
                //先放右节点
                if(cur.right != null) stack.push(cur.right);
                cur = cur.left;
            }
        }
        return res;
    }
}
