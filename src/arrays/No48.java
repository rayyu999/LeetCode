package arrays;

public class No48 {

    /**
     * 转置后翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j * 2 < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }

    /**
     * 逐层翻转
     * @param matrix
     */
    public void rotate_layer(int[][] matrix) {
        int layerNum = matrix.length >> 1, layer = 0;
        while (layer <= layerNum) {
            int len = matrix.length - (layer << 1);
            for (int i = 0; i < len - 1; ++i) {
                // 将上面的边元素先保存起来
                int tmp = matrix[layer][layer+i];
                // 每次将边上对应位置的元素顺时针旋转
                // 上面的边换成左边的边
                matrix[layer][layer+i] = matrix[layer+len-i-1][layer];
                // 左边的边换成下面的边
                matrix[layer+len-i-1][layer] = matrix[layer+len-1][layer+len-i-1];
                // 下面的边换成右边的边
                matrix[layer+len-1][layer+len-i-1] = matrix[layer+i][layer+len-1];
                // 右边的边换成上面的边
                matrix[layer+i][layer+len-1] = tmp;
            }
            ++layer;
        }
    }

}
