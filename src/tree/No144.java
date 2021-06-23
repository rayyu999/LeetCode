package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Ray
 * @Date 2021/6/23 22:46
 * @Description 144.二叉树的前序遍历
 */
public class No144 {

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                while (p != null) {
                    res.add(p.val);
                    stack.push(p.right);
                    p = p.left;
                }
            }
        }
        return res;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal_recur(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recur(root, res);
        return res;
    }

    private void recur(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            recur(root.left, list);
            recur(root.right, list);
        }
    }

}
