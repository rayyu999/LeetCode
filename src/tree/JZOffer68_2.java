package tree;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Ray
 * @Date 2021/6/23 22:53
 * @Description 剑指 Offer 68 - II. 二叉树的最近公共祖先
 */
public class JZOffer68_2 {

    /**
     * 递归解法
     */
    static class RecurSolution {
        Map<TreeNode, Boolean> memo;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            memo = new HashMap<>();
            return recur(root, p, q);
        }

        private TreeNode recur(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (contain(root.left, p, q) && contain(root.right, p, q)) {
                return root;
            }
            if (root == p || root == q) {
                return root;
            }
            boolean left = contain(root.left, p, q);
            if (left) {
                return recur(root.left, p, q);
            }
            return recur(root.right, p, q);
        }

        private boolean contain(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return false;
            }
            if (memo.containsKey(root)) {
                return memo.get(root);
            }
            if (root == p || root == q) {
                memo.put(root, true);
                return true;
            }
            boolean left = contain(root.left, p, q);
            boolean right = contain(root.right, p, q);
            if (left || right) {
                memo.put(root, true);
                return true;
            }
            memo.put(root, false);
            return false;
        }
    }

    /**
     * 记录父节点解法
     */
    static class ParentSolution {
        Map<TreeNode, TreeNode> parents;
        Set<TreeNode> visited;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            parents = new HashMap<>();
            visited = new HashSet<>();
            buildMap(root);
            TreeNode parent = p;
            while (parent != null) {
                visited.add(parent);
                parent = parents.getOrDefault(parent, null);
            }
            parent = q;
            while (parent != null) {
                if (visited.contains(parent)) {
                    return parent;
                }
                parent = parents.getOrDefault(parent, null);
            }
            return null;
        }

        private void buildMap(TreeNode root) {
            if (root.left != null) {
                parents.put(root.left, root);
                buildMap(root.left);
            }
            if (root.right != null) {
                parents.put(root.right, root);
                buildMap(root.right);
            }
        }
    }

}
