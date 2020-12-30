package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No1046 {

    /**
     * 递归
     * @param stones
     * @return
     */
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

    /**
     * 最大堆
     * @param stones
     * @return
     */
    public int lastStoneWeight_heap(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) pq.offer(a - b);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
