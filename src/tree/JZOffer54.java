package tree;

import datastructure.TreeNode;

import java.util.Stack;

public class JZOffer54 {

    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        int cnt = 0;
        TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.right;
            }
            p = s.pop();
            if (++cnt == k) {
                return p.val;
            }
            p = p.left;
        }
        return -1;
    }

}
