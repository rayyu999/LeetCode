package dfs;

import java.util.HashMap;
import java.util.Map;

public class No123 {

    public int maxProfit(int[] prices) {
        Map<Key, Integer> map = new HashMap<>();
        return dfs(prices, 0, 0, 0, map);
    }

    private int dfs(int[] prices, int index, int status, int k, Map<Key, Integer> map) {
        // 递归终止条件
        if (k == 2 || index >= prices.length) return 0;
        Key key = new Key(index, status, k);
        if (map.containsKey(key)) return map.get(key);
        // 定义三个变量记录买、卖、不动
        int buy = 0, sell = 0, hold = 0;
        // 不动的情况
        hold = dfs(prices, index+1, status, k, map);
        if (status == 1) {
            // 递归处理卖的情况
            sell = dfs(prices, index+1, 0, k+1, map) + prices[index];
        } else {
            // 递归处理买的情况
            buy = dfs(prices, index+1, 1, k, map) - prices[index];
        }
        int cur = Math.max(hold, Math.max(sell, buy));
        map.put(key, cur);
        return cur;
    }

    // Key对象封装了index、status、交易次数，作为map的key
    private class Key {

        final int index;
        final int status;
        final int k;

        Key(int index,int status,int k) {
            this.index = index;
            this.status = status;
            this.k = k;
        }

        //这里需要实现自定义的equals和hashCode函数
        public int hashCode() {
            return this.index + this.status + this.k;
        }

        public boolean equals(Object obj) {
            Key other = (Key)obj;
            if(index==other.index && status==other.status && k==other.k) {
                return true;
            }
            return false;
        }

    }

}
