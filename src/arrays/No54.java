package arrays;

import java.util.ArrayList;
import java.util.List;

public class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        int[][] visited = new int[r][c];
        int i = 0, j = 0, cnt = 0;
        List<Integer> res = new ArrayList<>();
        // 遍历整个矩阵
        while (cnt < r * c) {
            // 往右走
            while (j < c && visited[i][j] == 0) {
                res.add(matrix[i][j]);
                ++cnt;
                visited[i][j] = 1;
                ++j;
            }
            // 扫描完一整行后指向上次访问元素下面的一个元素
            --j;
            ++i;
            // 往下走
            while (i < r && visited[i][j] == 0) {
                res.add(matrix[i][j]);
                ++cnt;
                visited[i][j] = 1;
                ++i;
            }
            // 扫描完一整列后指向上次访问元素左边的一个元素
            --i;
            --j;
            // 往左走
            while (j >= 0 && visited[i][j] == 0) {
                res.add(matrix[i][j]);
                ++cnt;
                visited[i][j] = 1;
                --j;
            }
            // 扫描完一整行后指向上次访问元素上面的一个元素
            ++j;
            --i;
            // 往上走
            while (i >= 0 && visited[i][j] == 0) {
                res.add(matrix[i][j]);
                ++cnt;
                visited[i][j] = 1;
                --i;
            }
            // 扫描完一整行后指向上次访问元素左边的一个元素
            ++i;
            ++j;
        }
        return res;
    }

}
