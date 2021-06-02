package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/6/2 22:04
 * @Description 523.连续的子数组和
 */
public class No523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int r = 0;
        // 先存(0, -1)，处理子数组是从原数组首开始的情况
        map.put(r, -1);
        for (int i = 0; i < n; ++i) {
            r = (r + nums[i]) % k;
            if (map.containsKey(r)) {
                int lastIndex = map.get(r);
                if (i - lastIndex >= 2) {
                    return true;
                }
            } else {
                map.put(r, i);
            }
        }
        return false;
    }

}
