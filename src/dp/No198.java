package dp;

/**
 * @Author Ray
 * @Date 2021/7/1 23:12
 * @Description 198.打家劫舍
 */
public class No198 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums[0];
        }
        int yes = nums[0], no = 0;
        int max = nums[0];
        for (int i = 1; i < n; ++i) {
            // 这家偷 -> 上一家不偷
            int curYes = no + nums[i];
            // 这家不偷 -> 上一家可偷可不偷
            int curNo = Math.max(yes, no);
            max = Math.max(max, Math.max(curYes, curNo));
            yes = curYes;
            no = curNo;
        }
        return max;
    }

}
