package TreeAndHeap.SearchTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/15/7:58
 * @Description:
 */
public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //相同方向则继续向下寻找
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}
