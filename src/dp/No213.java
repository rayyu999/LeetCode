package dp;

/**
 * @Author Ray
 * @Date 2021/7/1 23:13
 * @Description 213.打家劫舍II
 */
public class No213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int yes1 = nums[0], no1 = 0;
        int yes2 = nums[1], no2 = 0;
        int max = Math.max(nums[0], nums[1]);
        for (int i = 1; i < n-1; ++i) {
            // 计算第一个队列
            int curYes = no1 + nums[i];
            int curNo = Math.max(yes1, no1);
            max = Math.max(max, Math.max(curYes, curNo));
            yes1 = curYes;
            no1 = curNo;
            // 计算第二个队列
            curYes = no2 + nums[i+1];
            curNo = Math.max(yes2, no2);
            max = Math.max(max, Math.max(curYes, curNo));
            yes2 = curYes;
            no2 = curNo;
        }
        return max;
    }

}
