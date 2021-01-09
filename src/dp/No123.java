package dp;

public class No123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int s1, s2, s3, s4;
        s1 = Integer.MIN_VALUE;
        s2 = 0;
        s3 = Integer.MIN_VALUE;
        s4 = 0;
        for (int price : prices) {
            // 在该天及之前最后一次操作为第一次买入股票时，可获得的最大收益
            s1 = Math.max(s1, -price);
            // 在该天及之前最后一次操作为第一次卖出股票时，可获得的最大收益
            s2 = Math.max(s2, s1 + price);
            // 在该天及之前最后一次操作为第二次买入股票时，可获得的最大收益
            s3 = Math.max(s3, s2 - price);
            // 在该天及之前最后一次操作为第二次卖出股票时，可获得的最大收益
            s4 = Math.max(s4, s3 + price);
        }
        return s4;
    }

}
