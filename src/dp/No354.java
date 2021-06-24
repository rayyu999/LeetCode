package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Ray
 * @Date 2021/6/24 22:57
 * @Description 354.俄罗斯套娃信封问题
 */
public class No354 {

    public int maxEnvelopes(int[][] envelopes) {
        // 先按宽度升序排序，宽度一样按高度排序
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        // 然后使用LIS算法
        int n = envelopes.length, max = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < n; ++j) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
