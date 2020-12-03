package tree;

import datastructure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

public class JZOffer7 {

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    /**
     * 哈希表记录法（快）
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_Hash(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

    /**
     * 数组拷贝法
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // 前序数组的第一个元素为当前子树的根节点
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0;
        for (int i = 0; i < inorder.length; ++i) {
            // 找当前子树的根节点在中序数组中的位置
            if (inorder[i] == root.val)
                index = i;
        }
        // 递归计算子树
        // 左子树的前序数组范围为[1, index]，中序数组范围为[0, index-1]
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1),
                Arrays.copyOfRange(inorder, 0, index));
        // 右子树的前序数组范围为[index+1, preorder.length]，中序数组范围为[index+1, inorder.length]
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length),
                Arrays.copyOfRange(inorder, index+1, inorder.length));
        return root;
    }

}
