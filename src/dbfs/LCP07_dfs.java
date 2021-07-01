package dbfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/7/1 23:15
 * @Description LCP 07.传递信息 - DFS解法
 */
public class LCP07_dfs {

    private int cnt;
    private Map<Integer, List<Integer>> trans;

    public int numWays(int n, int[][] relation, int k) {
        cnt = 0;
        trans = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            trans.put(i, new ArrayList<>());
        }
        for (int[] r : relation) {
            trans.get(r[0]).add(r[1]);
        }
        dfs(0, n-1, k);
        return cnt;
    }

    private void dfs(int index, int target, int step) {
        if (step == 0) {
            if (index == target) {
                ++cnt;
            }
        }
        if (step > 0) {
            List<Integer> nexts = trans.get(index);
            for (int next : nexts) {
                dfs(next, target, step-1);
            }
        }
    }

}
