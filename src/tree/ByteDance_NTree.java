package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class ByteDance_NTree {

    /**
     * 将树序列化成字符串列表
     * @param root
     * @return
     */
    public List<String> serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeRecur(root, "", list);
        return list;
    }

    /**
     * 将字符串列表反序列化成树
     * @param list
     * @return
     */
    public TreeNode deserialize(List<String> list) {
        Stack<TreeNode> parents = new Stack<>();
        return deserializeRecur(list, parents, 0);
    }

    /**
     * 递归进行序列化
     * @param node
     * @param prefix
     * @param list
     */
    private void serializeRecur(TreeNode node, String prefix, List<String> list) {
        if (Objects.nonNull(node)) {
            // 前序遍历，先把当前访问到的节点加入列表
            list.add(prefix + node.val);
            // 再访问其子节点
            for (TreeNode child : node.childs) {
                serializeRecur(child, prefix + "--", list);
            }
        }
    }

    /**
     * 递归进行反序列化
     * @param list
     * @param parents
     * @param layer
     * @return
     */
    private TreeNode deserializeRecur(List<String> list, Stack<TreeNode> parents, int layer) {
        if (list.size() > 0) {
            // 获取当前待解析字符串长度
            int len = list.get(0).length();
            String val = String.valueOf(list.get(0).charAt(len-1));
            TreeNode node = new TreeNode(val);
            if (!parents.isEmpty()) {
                TreeNode parent = parents.peek();
                parent.setChild(node);
            }
            parents.push(node);
            list.remove(0);
            // 继续往下递归
            while (true) {
                if (list.size() <= 0) {
                    break;
                }
                boolean isNextLayer = isNextLayer(list.get(0), layer);
                // 若访问到不为子节点的元素，跳出循环
                if (!isNextLayer) {
                    break;
                }
                // 否则下一个节点是当前节点的子节点，继续递归
                deserializeRecur(list, parents, layer + 1);
            }
            parents.pop();
            return node;
        }
        return null;
    }

    /**
     * 查看是否为下一层的元素
     * @param str
     * @param layer
     * @return
     */
    private boolean isNextLayer(String str, int layer) {
        int len = str.length();
        // 计算当前列表的首元素是哪一层
        int curLayer = 0;
        for (int i = 0; i < len - 1; ++i) {
            if (str.charAt(i) == '-') {
                ++curLayer;
            }
        }
        // 横杠数除以2即为当前层数
        curLayer /= 2;
        // 若当前层数不是期望的层数（即当前元素不是栈顶元素的子节点），直接返回
        if (curLayer != layer + 1) {
            return false;
        }
        return true;
    }

    /**
     * 树节点
     */
    static class TreeNode {

        /**
         * 节点值
         */
        String val;
        /**
         * 子节点列表
         */
        List<TreeNode> childs;

        TreeNode(String val) {
            this.val = val;
            childs = new ArrayList<>();
        }

        void setChild(TreeNode child) {
            this.childs.add(child);
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val='" + val + '\'' +
                    ", childs=" + childs +
                    '}';
        }
    }

}
