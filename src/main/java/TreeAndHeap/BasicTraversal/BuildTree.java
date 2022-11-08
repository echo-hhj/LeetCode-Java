package TreeAndHeap.BasicTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: echo-dundun
 * @Date: 2022/11/08/9:22
 * @Description: 通过前序遍历和中序遍历构造一棵树
 */
public class BuildTree {
    //存储节点所在位置
    static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        //构造哈希映射，便于快速找到中序遍历中的根节点位置
        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    private static TreeNode myBuildTree(int[] pre, int[] in, int pre_left, int pre_right, int in_left, int in_right) {
        //终止条件
        if (in_left > in_right) return null;

        //先序遍历的第一个节点为根节点
        int root_value = pre[pre_left];
        //在中序遍历中找到根节点位置
        int in_index = map.get(root_value);
        //新建根节点
        TreeNode root = new TreeNode(root_value);
        //左子树的节点个数
        int sub_left = in_index - in_left;
        //递归构造左子树
        root.left = myBuildTree(pre, in, pre_left + 1, pre_left + sub_left, in_left, in_index - 1);
        //递归构造右子树
        root.right = myBuildTree(pre, in, pre_left + sub_left + 1, pre_right, in_index + 1, in_right);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(buildTree(preorder, inorder));
    }
}
