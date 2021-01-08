package recursion;

import java.util.Arrays;

public class No1046 {

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        Arrays.sort(stones);
        // 只剩下两块石头
        if (stones[stones.length-3] == 0) {
            return Math.abs(stones[stones.length-2] - stones[stones.length-1]);
        }
        // 将最大的两块石头一起粉碎
        stones[stones.length-1] -= stones[stones.length-2];
        stones[stones.length-2] = 0;
        // 递归处理
        return lastStoneWeight(stones);
    }

}
