package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            TreeNode p = root;
            q.offer(p);
            while(q.size() > 0) {
                int size = q.size(), layer = 0;
                for (int i = 0; i < size; ++i) {
                    p = q.poll();
                    layer = p.val;
                    if (p.left != null) {
                        q.offer(p.left);
                    }
                    if (p.right != null) {
                        q.offer(p.right);
                    }
                }
                res.add(layer);
            }
        }
        return res;
    }

}
