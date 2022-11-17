package TreeAndHeap.RecursiveTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/14/7:53
 * @Description:
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        //如果root节点的值大于val，说明值为val的节点应该在root
        //节点的左子树上
        if (root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;

    }
}
