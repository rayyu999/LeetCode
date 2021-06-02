package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Ray
 * @Date 2021/6/2 22:01
 * @Description 128.最长连续序列
 */
public class No128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num-1)) {
                int cur = num + 1, len = 1;
                while (set.contains(cur)) {
                    ++len;
                    ++cur;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

}
