package TreeAndHeap.BasicTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        //存放结果
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        //当前节点
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            //当前节点不为空则入栈，并向左子树遍历
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
