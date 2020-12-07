package greedy;

public class No861 {

    public int matrixScore(int[][] A) {
        int n = A.length, m = A[0].length;
        // 记录每一行的翻转情况
        boolean[] rev = new boolean[n];
        for (int i = 0; i < n; ++i) {
            rev[i] = A[i][0] == 1 ? false : true;
        }
        // 先统计第一列的得分
        int res = n * (1 << (m - 1));
        // 比较其余每一列 0 与 1 的个数
        for (int col = 1; col < m; ++col) {
            int cnt = 0;    // 统计 1 的个数
            for (int row = 0; row < n; ++row) {
                if (rev[row]) A[row][col] ^= 1;
                if (A[row][col] == 1) ++cnt;
            }
            // 若 1 比 0 少则翻转该列
            cnt = cnt > n / 2 ? cnt : n - cnt;
            // 计算该列得分
            res += cnt * (1 << (m - col - 1));
        }
        return res;
    }

}
