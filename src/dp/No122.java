package dp;

/**
 * @Author Ray
 * @Date 2021/7/14 21:50
 * @Description 122. 买卖股票的最佳时机 II
 */
public class No122 {

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit_dp(int[] prices) {
        int hold = -prices[0], unhold = 0;
        for (int i = 1; i < prices.length; ++i) {
            int curHold = Math.max(hold, unhold - prices[i]);
            int curUnhold = Math.max(unhold, hold + prices[i]);
            hold = curHold;
            unhold = curUnhold;
        }
        return unhold;
    }


    /**
     * 贪心
     * @param prices
     * @return
     */
    public int maxProfit_greedy(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

}
