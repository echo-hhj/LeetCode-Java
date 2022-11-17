package TreeAndHeap.RecursiveTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/13/10:59
 * @Description:
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        targetSum -= root.val;
        if((root.left == null) && (root.right == null)){
            return (targetSum == 0);
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
