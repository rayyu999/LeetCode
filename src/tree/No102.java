package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            TreeNode p = root;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(p);
            while (q.size() > 0) {
                List<Integer> list = new ArrayList<>();
                int size = q.size();
                // 只访问当前层的节点
                for (int i = 0; i < size; ++i) {
                    p = q.poll();
                    list.add(p.val);
                    if (p.left != null) {
                        q.offer(p.left);
                    }
                    if (p.right != null) {
                        q.offer(p.right);
                    }
                }
                res.add(list);
            }
        }
        return res;
    }

}
