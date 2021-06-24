package dp;

/**
 * @Author Ray
 * @Date 2021/6/24 22:56
 * @Description 300.最长递增子序列
 */
public class No300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
