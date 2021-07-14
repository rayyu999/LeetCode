package dp;

/**
 * @Author Ray
 * @Date 2021/7/14 21:54
 * @Description 1014. 最佳观光组合
 */
public class No1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }

}
