package arrays;

import java.util.HashMap;
import java.util.Map;

public class No454 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        // 将a+b的值添加到哈希表中
        for (int a : A) {
            for (int b : B) {
                int cnt = map.getOrDefault(a + b, 0);
                map.put(a + b, cnt + 1);
            }
        }
        // 遍历c+d，统计满足元组的个数
        for (int c : C) {
            for (int d : D) {
                int diff = - (c + d);
                if (map.containsKey(diff)) res += map.get(diff);
            }
        }
        return res;
    }

}
