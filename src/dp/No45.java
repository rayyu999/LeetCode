package dp;

/**
 * @Author Ray
 * @Date 2021/7/14 21:48
 * @Description 45. 跳跃游戏 II
 */
public class No45 {

    public int jump(int[] nums) {
        int cur = nums.length - 1, min = 0;
        while (cur > 0) {
            int minPre = cur, pre = cur - 1;
            while (pre >= 0) {
                if (nums[pre] >= cur - pre) {
                    minPre = pre;
                }
                --pre;
            }
            cur = minPre;
            ++min;
        }
        return min;
    }

}
