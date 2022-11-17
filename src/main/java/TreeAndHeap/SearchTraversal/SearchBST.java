package TreeAndHeap.SearchTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/15/7:53
 * @Description:
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (val > root.val) {
            return searchBST(root.right, val);
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}
