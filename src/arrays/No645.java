package arrays;

import java.util.Arrays;

/**
 * @Author Ray
 * @Date 2021/7/6 23:10
 * @Description 645.错误的集合
 */
public class No645 {

    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int cur = 0, pre = 0;
        for (int num : nums) {
            cur = num;
            if (cur == pre) {
                res[0] = cur;
            } else if (cur - pre >= 2) {
                res[1] = pre + 1;
            }
            pre = cur;
        }
        if (nums[nums.length-1] != nums.length) {
            res[1] = nums.length;
        }
        return res;
    }

}
