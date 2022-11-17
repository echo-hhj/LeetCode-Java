package TreeAndHeap.RecursiveTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/14/9:04
 * @Description:
 */
public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        //计算左右节点个数
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
