package tree;

import datastructure.TreeNode;

/**
 * @Author Ray
 * @Date 2021/6/16 22:14
 * @Description 剑指 Offer 68-I. 二叉搜索树的最近公共祖先
 */
public class JZOffer68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val <= root.val && q.val >= root.val) {
            return root;
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
