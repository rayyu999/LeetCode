package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/6/5 11:19
 * @Description 525.连续数组
 */
public class No525 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }
            if (map.containsKey(count)) {
                // 计算子数组的长度
                int lastIndex = map.get(count);
                max = Math.max(max, i - lastIndex);
            } else {
                // 将当前前缀和以及索引存储到哈希表中
                map.put(count, i);
            }
        }
        return max;
    }

}
