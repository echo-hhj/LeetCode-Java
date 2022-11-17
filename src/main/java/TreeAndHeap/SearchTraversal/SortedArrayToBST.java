package TreeAndHeap.SearchTraversal;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/15/7:37
 * @Description:
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) return new TreeNode(nums[0]);
        //中序遍历构造
        return ArrayBST(nums, 0, nums.length - 1);
    }

    private TreeNode ArrayBST(int[] nums, int left, int right) {
        if (left > right) return null;
        //取中间节点作为根节点
        int mid = (left + right) / 2;
        TreeNode root =  new TreeNode(nums[mid]);
        //递归左右子树
        root.left = ArrayBST(nums, left, mid - 1);
        root.right = ArrayBST(nums, mid + 1, right);
        return  root;
    }
}
