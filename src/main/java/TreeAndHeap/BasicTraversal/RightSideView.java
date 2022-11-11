package TreeAndHeap.BasicTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        //结果列表
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offer(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            //获取当前层的节点个数
            int size = stack.size();
            while (size-- != 0) {
                cur = stack.poll();
                //如果当前节点是最后一个节点则加入结果
                if (size == 0) res.add(cur.val);
                //将不为空的左右节点依次入栈
                if (cur.left != null) stack.offer(cur.left);
                if (cur.right != null) stack.offer(cur.right);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }
}
