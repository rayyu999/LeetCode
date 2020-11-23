package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class No452 {

    public int findMinArrowShots(int[][] points) {
        int ans = 0, i = 0;
        // 将每个气球按右端点从小到大排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        // 遍历数组，每次将一支箭从当前访问气球的右端点射出，统计箭的数量
        while (i < points.length) {
            ++ans;
            int arrow = points[i++][1];
            // 将范围包括弓箭坐标的气球引爆
            while (i < points.length && (points[i][0] <= arrow && points[i][1] >= arrow)) ++i;
        }
        return ans;
    }

}
