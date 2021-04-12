package tree;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No236 {

    TreeNode res = null;

    /**
     * 后序遍历法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_lastOrder(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root == p || root == q) && (left || right))) {
            res = root;
        }
        return left || right || root == p || root == q;
    }

    /**
     * 存储父节点法
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor_storeParent(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> parents = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        buildMap(root, parents);
        while (p != null) {
            visited.add(p.val);
            p = parents.getOrDefault(p.val, null);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parents.getOrDefault(q.val, null);
        }
        return null;
    }

    private void buildMap(TreeNode root, Map<Integer, TreeNode> parents) {
        if (root != null) {
            if (root.left != null) {
                parents.put(root.left.val, root);
                buildMap(root.left, parents);
            }
            if (root.right != null) {
                parents.put(root.right.val, root);
                buildMap(root.right, parents);
            }
        }
    }

}
