package dp;

/**
 * @Author Ray
 * @Date 2021/7/1 23:18
 * @Description LCP 07.传递信息 - 动态规划解法
 */
public class LCP07_dp {

    public int numWays(int n, int[][] relation, int k) {
        // dp[i][j] 表示第i轮传递到第j个人的方案个数
        int[][] dp = new int[k+1][n];
        // 第0轮传递到第0个人只有一种方案
        dp[0][0] = 1;
        for (int i = 1; i <= k; ++i) {
            for (int[] r : relation) {
                dp[i][r[1]] += dp[i-1][r[0]];
            }
        }
        return dp[k][n-1];
    }

}
