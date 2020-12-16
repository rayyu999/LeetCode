package dp;

public class JZOffer14_1 {

    public int cuttingRope(int n) {
        int[] product = new int[n + 1];
        product[1] = 1;
        // 从下往上计算
        for (int i = 2; i <= n; ++i) {
            // 枚举剪绳子的位置
            for (int j = 1; j * 2 <= i; ++j) {
                // 计算当前绳子长度能拆分乘积的最大值
                product[i] = Math.max(product[i], Math.max(j, product[j]) * Math.max(i-j, product[i-j]));
            }
        }
        return product[n];
    }

}
