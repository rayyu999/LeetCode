package dp;

/**
 * @Author Ray
 * @Date 2021/7/6 23:17
 * @Description 面试题 17.24. 最大子矩阵
 */
public class Meeting17_24 {

    public int[] getMaxMatrix(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[] res = new int[4], b = new int[c];
        int r1 = 0, c1 = 0, max = Integer.MIN_VALUE;
        // 枚举矩阵上边
        for (int i = 0; i < r; ++i) {
            // 每次更换上边，就要清空b
            for (int t = 0; t < c; ++t) {
                b[t] = 0;
            }
            // 枚举矩阵下边
            for (int j = i; j < r; ++j) {
                int sum = 0;
                // 计算最大子序和
                for (int k = 0; k < c; ++k) {
                    b[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += b[k];
                    } else {
                        // 从当前位置重新开始
                        sum = b[k];
                        r1 = i;
                        c1 = k;
                    }
                    // 更新答案
                    if (sum > max) {
                        max = sum;
                        res[0] = r1;
                        res[1] = c1;
                        res[2] = j;
                        res[3] = k;
                    }
                }
            }
        }
        return res;
    }

}
