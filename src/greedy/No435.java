package greedy;

import java.util.Arrays;

public class No435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 按区间终点进行排序
        Arrays.sort(intervals, (a, b) -> {return a[1] - b[1];});
        int count = 1, end = intervals[0][1];
        // 计算最大能分成几个区间
        for (int i = 1; i < intervals.length; ++i) {
            // 将起点在上一个区间范围内的区间剔除
            if (intervals[i][0] < end) continue;
            end = intervals[i][1];
            ++count;
        }
        // 最终需要剔除区间的个数为总区间数减最大能分的区间数
        return intervals.length - count;
    }

}
