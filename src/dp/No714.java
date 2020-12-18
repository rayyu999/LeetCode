package dp;

public class No714 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length, hold = -prices[0], notHold = 0;
        for (int i = 1; i < n; ++i) {
            // 未持有股票
            notHold = Math.max(notHold, hold + prices[i] - fee);
            // 持有股票
            hold = Math.max(hold, notHold - prices[i]);
        }
        return notHold;
    }

}
