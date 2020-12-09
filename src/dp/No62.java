package dp;

public class No62 {

    /**
     * 动态规划法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // 要到达第一行和第一列的格子只有一种走法
                // 其它格子的走法为左边格子的走法与上面格子的走法之和
                dp[i][j] = (i == 0 || j == 0) ? 1 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 排列组合法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_math(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
