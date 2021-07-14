package dp;

/**
 * @Author Ray
 * @Date 2021/7/14 21:48
 * @Description 55. 跳跃游戏
 */
public class No55 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public boolean canJump_dp(int[] nums) {
        // 维护变量存储当前能到达的最远位置
        int maxPos = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            // 当前位置不能到达，返回false
            if (i > maxPos) return false;
            // 更新能到达的最远位置
            maxPos = Math.max(maxPos, i + nums[i]);
            // 能到达的最远位置比数组长度大，返回true
            if (maxPos >= nums.length - 1) return true;
        }
        return false;
    }

    /**
     * 从后往前遍历
     * @param nums
     * @return
     */
    public boolean canJump_backward(int[] nums) {
        int cur = nums.length - 2;
        while (cur >= 0) {
            if (nums[cur] == 0) {
                // 往前找有没有能跳过当前位置的元素
                int pre = cur - 1;
                while (pre >= 0) {
                    // 找到了就跳出循环
                    if (nums[pre] > cur - pre) {
                        break;
                    }
                    --pre;
                }
                // 遍历完整个数组都没找到，无法到达
                if (pre < 0) {
                    return false;
                }
                cur = pre;
            } else {
                --cur;
            }
        }
        return true;
    }

}
