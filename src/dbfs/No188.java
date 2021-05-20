package dbfs;

import java.util.HashMap;
import java.util.Map;

public class No188 {

    public int maxProfit(int k, int[] prices) {
        Map<Key, Integer> map = new HashMap<>();
        return dfs(k, prices, 0, 0, 0, map);
    }

    private int dfs(int k, int[] prices, int index, int status, int cnt, Map<Key, Integer> map) {
        // 递归边界
        if (cnt == k || index >= prices.length) return 0;
        Key key = new Key(index, status, cnt);
        if (map.containsKey(key)) return map.get(key);
        // 定义三个变量记录买入、卖出、不动
        int buy = 0, sell = 0, hold = 0;
        hold = dfs(k, prices, index+1, status, cnt, map);
        if (status == 1) {
            // 卖出
            sell = dfs(k, prices, index+1, 0, cnt+1, map) + prices[index];
        } else {
            // 买入
            buy = dfs(k, prices, index+1, 1, cnt, map) - prices[index];
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

        Key(int index, int status, int k) {
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
