package tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            TreeNode p;
            // 第一层为从左往右遍历
            Boolean leftToRight = true;
            while (queue.size() > 0) {
                int cnt = queue.size();
                List<Integer> layer = new ArrayList<>();
                while (cnt > 0) {
                    p = queue.poll();
                    if (leftToRight) {
                        layer.add(p.val);
                    } else {
                        layer.add(0, p.val);
                    }
                    if (p.left != null) queue.offer(p.left);
                    if (p.right != null) queue.offer(p.right);
                    --cnt;
                }
                // 下一层的遍历顺序反转
                leftToRight = !leftToRight;
                res.add(layer);
            }
        }
        return res;
    }

}
