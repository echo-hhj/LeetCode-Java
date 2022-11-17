package TreeAndHeap.SearchTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/17/7:52
 * @Description:
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        //递归终止
        if (root == null) return null;
        //递归寻找与key相同的节点
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            //找到要删除的节点
            //如果被删节点的左右子树一方为空返回另一方
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            //如果左右子树都不为空，找到右子树的最左节点
            TreeNode pre = root;    //前驱节点
            TreeNode rightNode = root.right;
            while (rightNode.left != null) {
                pre = rightNode;
                rightNode = rightNode.left;
            }
            //删除root
            root.val = rightNode.val;
            //此时rightNode已经没有左子树了
            if (pre.left.val == rightNode.val) {
                pre.left = rightNode.right;
            } else {
                pre.right = rightNode.right;
            }
        }
        return root;
    }
}
