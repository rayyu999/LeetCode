package recursion;

import datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class No437 {

    int res;
    Map<Integer, Integer> preSum;

    public int pathSum(TreeNode root, int sum) {
        res = 0;
        preSum = new HashMap<>();
        preSum.put(0, 1);
        recur(root, sum, 0);
        return res;
    }

    private void recur(TreeNode root, int sum, int cur) {
        if (root != null) {
            cur += root.val;
            int diff = cur - sum;
            // 到map中查看当前路径有多少节点的前缀和满足 preSum[当前节点] - preSum[某节点] = sum
            // 满足上面的式子证明A到当前节点的路径和满足题目要求
            int cnt = preSum.getOrDefault(diff, 0);
            res += cnt;
            cnt = preSum.getOrDefault(cur, 0);
            // 把当前节点的前缀和放到map中
            preSum.put(cur, cnt + 1);
            // 向下递归
            recur(root.left, sum, cur);
            recur(root.right, sum, cur);
            // 跳出本层递归时要把当前节点的前缀和删除
            preSum.put(cur, cnt);
        }
    }

}
