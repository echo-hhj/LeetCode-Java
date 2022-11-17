package TreeAndHeap.RecursiveTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/14/9:14
 * @Description:
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        //存放结果
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, new StringBuilder());
        return res;
    }

    private void dfs(List<String> res, TreeNode node, StringBuilder s) {
        s.append(node.val);
        //当节点是叶子节点的时候把路径加入
        if (node.left == null && node.right == null) res.add(s.toString());
        if(node.left != null) dfs(res, node.left, new StringBuilder(s).append("->"));
        if(node.right != null) dfs(res, node.right, new StringBuilder(s).append("->"));
    }
}
