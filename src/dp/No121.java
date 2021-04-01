package dp;

public class No121 {

    public int maxProfit(int[] prices) {
        // 维护在当前日期之前的最小价格以及能获得的最大收益
        int minPrice = prices[0], max = 0;
        for (int i = 1; i < prices.length; ++i) {
            // 当前价格小于之前最小价格时更新最小价格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                continue;
            }
            // 计算在这天能获得的最大收益
            int tmp = prices[i] - minPrice;
            max = Math.max(tmp, max);
        }
        return max;
    }

}
