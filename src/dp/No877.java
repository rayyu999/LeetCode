package dp;

/**
 * @Author Ray
 * @Date 2021/6/16 22:13
 * @Description TODO
 */
public class No877 {

    /**
     * 动态规划
     * @param piles
     * @return
     */
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = piles[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j-1]);
            }
        }
        return dp[n-1] > 0;
    }

    /**
     * 数学
     * @param piles
     * @return
     */
    public boolean stoneGame_math(int[] piles) {
        return true;
    }

}
