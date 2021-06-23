package tree;

import datastructure.TreeNode;

/**
 * @Author Ray
 * @Date 2021/6/23 22:49
 * @Description 剑指 Offer 26. 树的子结构
 */
public class JZOffer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B != null) {
            if (recur(A, B)) {
                return true;
            }
            // 枚举A出发点
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return false;
    }

    private boolean recur(TreeNode A, TreeNode B) {
        // B 被遍历完，证明当前遍历路径中的结构都一样
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        // 若当前节点相等，继续遍历子树
        return A.val == B.val && recur(A.left, B.left) && recur(A.right, B.right);
    }

}
