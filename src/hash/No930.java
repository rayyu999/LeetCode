package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/7/14 21:53
 * @Description 930. 和相同的二元子数组
 */
public class No930 {

    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int cnt = map.getOrDefault(sum - goal, 0);
            res += cnt;
            cnt = map.getOrDefault(sum, 0);
            map.put(sum, cnt+1);
        }
        return res;
    }

}
