package greedy;

import java.util.HashMap;
import java.util.Map;

public class No659 {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> se = new HashMap<>();
        for (int num : nums) {
            int tmp = cnt.getOrDefault(num, 0);
            cnt.put(num, tmp + 1);
        }
        for (int num : nums) {
            // 当前数字已被使用完，直接进入下一次循环
            if (cnt.get(num) == 0) continue;

            int n = se.getOrDefault(num - 1, 0);
            if (n == 0) {
                // 如果没有以 num - 1 结尾的子序列，则新开子序列
                int tmp1 = cnt.getOrDefault(num + 1, 0);
                int tmp2 = cnt.getOrDefault(num + 2, 0);
                // 若新开不了子序列，返回 false
                if (tmp1 == 0 || tmp2 == 0) return false;

                // 将使用到的数字计数减一
                cnt.put(num + 1, tmp1 - 1);
                cnt.put(num + 2, tmp2 - 1);
                // 以 num + 2 结尾的子序列数量加一
                se.put(num + 2, se.getOrDefault(num + 2, 0) + 1);
            } else {
                // 若有则直接将 num 加入到某个子序列中
                se.put(num - 1, n - 1);     // 加入后以 num - 1 结尾的子序列数量减一
                se.put(num, se.getOrDefault(num, 0) + 1);  // 以 num 结尾的子序列数量加一
            }
            cnt.put(num, cnt.get(num) - 1);
        }
        return true;
    }

}
