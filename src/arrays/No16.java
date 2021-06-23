package arrays;

import java.util.Arrays;

/**
 * @Author Ray
 * @Date 2021/6/23 22:44
 * @Description 16.最接近的三数之和
 */
public class No16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        // 枚举第一个元素
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1, k = nums.length-1;
            // 枚举后两个元素
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    // 往更小的方向寻找
                    --k;
                } else {
                    // 往更大的方向寻找
                    ++j;
                }
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
            }
        }
        return res;
    }

}
