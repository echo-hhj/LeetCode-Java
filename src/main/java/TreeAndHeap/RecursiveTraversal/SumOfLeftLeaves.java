package TreeAndHeap.RecursiveTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/14/7:39
 * @Description:
 */
public class SumOfLeftLeaves {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        //终止条件
        if (root == null) return 0;
        //判断是否是左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return sum;

    }
}
