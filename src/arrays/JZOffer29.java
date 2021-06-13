package arrays;

/**
 * @ClassName JZOffer29
 * @Author 36d
 * @Date 2021/6/13 12:17
 * @Description 剑指Offer29.顺时针打印矩阵
 **/
public class JZOffer29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length > 0) {
            int n = matrix.length, m = matrix[0].length;
            int[] res = new int[n*m];
            // 定义当前的上下左右边界
            int left = 0, right = m-1, up = 0, down = n-1, cnt = 0;
            while (true) {
                // 打印上边界
                for (int i = left; i <= right; ++i) {
                    res[cnt++] = matrix[up][i];
                }
                if (++up > down) break;
                // 打印右边界
                for (int i = up; i <= down; ++i) {
                    res[cnt++] = matrix[i][right];
                }
                if (--right < left) break;
                // 打印下边界
                for (int i = right; i >= left; --i) {
                    res[cnt++] = matrix[down][i];
                }
                if (--down < up) break;
                // 打印左边界
                for (int i = down; i >= up; --i) {
                    res[cnt++] = matrix[i][left];
                }
                if (++left > right) break;
            }
            return res;
        }
        return new int[0];
    }

}
