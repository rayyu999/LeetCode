package dp;

/**
 * @Author Ray
 * @Date 2021/6/16 22:09
 * @Description 486.预测赢家
 */
public class No486 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        // 只有一个数可以选择，差值就为这个数
        for (int i = 0; i < n; ++i) {
            dp[i][i] = nums[i];
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                // 选择使得差值最大的
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public boolean PredictTheWinner_recur(int[] nums) {
        return pickScore(nums, 0, nums.length-1, 1) >= 0;
    }

    private int pickScore(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int pickStart = nums[start] * turn + pickScore(nums, start+1, end, -turn);
        int pickEnd = nums[end] * turn + pickScore(nums, start, end-1, -turn);
        // 按最大化分数来选，先手选max，而后手要选min
        return turn == 1 ? Math.max(pickStart, pickEnd) : Math.min(pickStart, pickEnd);
    }

}
