package tree;

import datastructure.TreeNode;

public class JZOffer55_2 {

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = left == -1 ? -1 : depth(node.right);
        return right == -1 ? -1 : Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

}
