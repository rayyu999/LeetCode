package tree;

import datastructure.TreeNode;

public class No222 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;     // 递归边界为访问到空节点
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        // 根据完全二叉树的性质：
        // 若左右子树高度相等，则左子树一定为完全二叉树 (节点数为 2^h - 1)
        if (left == right) return countNodes(root.right) + (1 << left);
            // 若左右子树高度不相等，则右子树一定为完全二叉树
        else return countNodes(root.left) + (1 << right);
    }

    private int getDepth(TreeNode root) {
        int cnt = 0;
        while (root != null) {
            ++cnt;
            root = root.left;
        }
        return cnt;
    }

}
