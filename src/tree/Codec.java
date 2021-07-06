package tree;

import datastructure.TreeNode;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Ray
 * @Date 2021/7/6 23:13
 * @Description 剑指 Offer 37. 序列化二叉树
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 记录最后一次出现数字的位置
        int lastIndex = 0;
        // 层序遍历构造字符串
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = q.poll();
                if (tmp != null) {
                    // 节点不为null，记录节点值
                    if (tmp.val < 0) {
                        sb.append('-');
                    }
                    // 将数值转字符串
                    sb.append(StringUtils.itoa(Math.abs(tmp.val)));
                    sb.append(',');
                    lastIndex = sb.length();
                    // 将当前访问节点的子节点加入队列
                    q.offer(tmp.left);
                    q.offer(tmp.right);
                } else {
                    // 否则记录null值
                    sb.append("null,");
                }
            }
        }
        if (lastIndex > 0) {
            // 最后还要删除多余的null值
            sb.delete(lastIndex-1, sb.length());
        }
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<Integer> list = new ArrayList<>();
        char[] c = data.toCharArray();
        // 构造节点值列表
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'n') {
                // 存储空节点
                list.add(null);
            } else if ((c[i] >= '0' && c[i] <= '9') || c[i] == '-'){
                // 处理非空节点的值
                int tmp = 0, signal = 1;
                if (c[i] == '-') {
                    // 处理负数
                    signal = -1;
                    ++i;
                }
                while (c[i] >= '0' && c[i] <= '9') {
                    tmp = tmp*10 + c[i] - '0';
                    ++i;
                }
                list.add(tmp * signal);
            }
        }
        // 层序遍历构造二叉树
        // q队列存储子节点列表，与wait队列配合
        Queue<Integer> q = new LinkedList<>();
        for (Integer e : list) {
            q.offer(e);
        }
        // 根节点不为空才开始构造
        if (q.size() > 0 && q.peek() != null) {
            // wait队列存储还没设置子节点的节点
            Queue<TreeNode> wait = new LinkedList<>();
            TreeNode root = new TreeNode(q.poll());
            wait.offer(root);
            while (wait.size() > 0) {
                TreeNode tmp = wait.poll();
                if (q.size() > 0) {
                    // 根据层序遍历的特点，q队列的头两个元素一定是当前遍历节点的左右子节点
                    Integer leftVal = q.poll();
                    Integer rightVal = q.poll();
                    if (leftVal != null) {
                        TreeNode left = new TreeNode(leftVal);
                        tmp.left = left;
                        wait.offer(left);
                    }
                    if (rightVal != null) {
                        TreeNode right = new TreeNode(rightVal);
                        tmp.right = right;
                        wait.offer(right);
                    }
                }
            }
            return root;
        }
        return null;
    }

}
