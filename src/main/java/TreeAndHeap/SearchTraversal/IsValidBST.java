package TreeAndHeap.SearchTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/16/8:24
 * @Description:
 */
public class IsValidBST {
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        //判断左子树
        if (!isValidBST(root.left)) return false;
        //验证
        if (pre != null && root.val <= pre.val) return false;

        pre = root;

        return isValidBST(root.right);
    }
}
