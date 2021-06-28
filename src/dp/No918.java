package dp;

/**
 * @Author Ray
 * @Date 2021/6/28 22:22
 * @Description 918.环形子数组的最大和
 */
public class No918 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, preSum = 0;
        int preMax = Integer.MIN_VALUE, preMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            preSum += nums[i];
            preMax = nums[i] + Math.max(preMax, 0);
            max = Math.max(max, preMax);
            if (i > 0 && i < n-1) {
                // 更新[1, n-1]区间中的最小和
                preMin = nums[i] + Math.min(preMin, 0);
                min = Math.min(min, preMin);
            }
        }
        // n <= 2 时不用考虑环形的情况
        return n > 2 ? Math.max(max, preSum-min) : max;
    }

}
