package arrays;

/**
 * @Author Ray
 * @Date 2021/6/2 22:06
 * @Description 1744.你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 */
public class No1744 {

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length, m = candiesCount.length;
        boolean[] ans = new boolean[n];
        long[] preSum = new long[m];
        long sum = 0;
        // 计算前缀和
        for (int i = 0; i < m; ++i) {
            sum += candiesCount[i];
            preSum[i] = sum;
        }
        for (int i = 0; i < n; ++i) {
            int favoriteType = queries[i][0], favoriteDay = queries[i][1], dailyCap = queries[i][2];
            // 计算当前糖果在总数中的区间为 [ preSum[favoriteType-1]+1, preSum[favoriteType] ]
            long candyLeft = favoriteType == 0 ? 1 : preSum[favoriteType-1]+1;
            long candyRight = preSum[favoriteType];
            // 计算当前天数能吃到糖果数的范围为 [ favoriteDay+1, favoriteDay*dailyCap ]
            long dayLeft = favoriteDay + 1;
            long dayRight = (long) (favoriteDay+1) * dailyCap;
            // 若两个区间有交集，则能吃到
            if (hasIntersection(candyLeft, candyRight, dayLeft, dayRight)) {
                ans[i] = true;
            }
        }
        return ans;
    }

    /**
     * 判断两个区间是否有交集
     * @param aLeft
     * @param aRight
     * @param bLeft
     * @param bRigth
     * @return
     */
    private boolean hasIntersection(long aLeft, long aRight, long bLeft, long bRigth) {
        return !(aLeft > bRigth || bLeft > aRight);
    }

}
