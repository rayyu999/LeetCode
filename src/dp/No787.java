package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/6/20 21:49
 * @Description 787.K站中转内最便宜的航班
 */
public class No787 {

    Map<Integer, List<int[]>> indegrees;
    int src;
    int[][] memo;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        indegrees = new HashMap<>();
        this.src = src;
        memo = new int[n][k+2];
        // 统计每个节点的入度
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], w = flight[2];
            List<int[]> tmp = indegrees.getOrDefault(to, new ArrayList<int[]>());
            tmp.add(new int[]{from, w});
            indegrees.put(to, tmp);
        }
        return recur(dst, k+1);
    }

    private int recur(int cur, int k) {
        // 到达起点，返回0
        if (cur == this.src) {
            return 0;
        }
        // 超出限制，返回-1
        if (k == 0) {
            return -1;
        }
        // 防止重复计算
        if (memo[cur][k] != 0) {
            return memo[cur][k];
        }
        int res = Integer.MAX_VALUE;
        List<int[]> indegree = indegrees.get(cur);
        if (indegree != null) {
            for (int[] side : indegree) {
                int subProblem = recur(side[0], k-1);
                // 若该子问题无解，直接跳过
                if (subProblem == -1) {
                    continue;
                }
                // 动态转移方程
                res = Math.min(res, subProblem + side[1]);
            }
        }
        // 记录计算结果
        memo[cur][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[cur][k];
    }
    
}
