package tree;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class No105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 先构造中序遍历哈希表，方便快速找到节点在中序遍历数组中的位置
        Map<Integer, Integer> map = buildHash(inorder);
        int len = preorder.length;
        return recur(preorder, inorder, map, 0, len-1, 0, len-1);
    }

    private TreeNode recur(int[] preorder, int[] inorder, Map<Integer, Integer> map, int pre_low, int pre_high, int in_low, int in_high) {
        if (pre_low > pre_high) {
            return null;
        }
        // 子树的根节点为当前切分子数组的首元素
        TreeNode root = new TreeNode(preorder[pre_low]);
        int in_root = map.get(root.val);
        // 获取左子树的节点数量
        int leftCnt = in_root - in_low;
        // 递归处理左子树
        TreeNode left = recur(preorder, inorder, map, pre_low + 1, pre_low + leftCnt, in_low, in_root - 1);
        // 递归处理右子树
        TreeNode right = recur(preorder, inorder, map, pre_low + leftCnt + 1, pre_high, in_root + 1, in_high);
        root.left = left;
        root.right = right;
        return root;
    }

    private Map<Integer, Integer> buildHash(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        // 构造中序遍历节点的索引哈希表
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return map;
    }

}
