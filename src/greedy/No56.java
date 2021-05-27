package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Ray
 * @Date 2021/5/27 23:43
 * @Description
 */
public class No56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] interval : intervals) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(interval[0]);
            tmp.add(interval[1]);
            if (lists.size() > 0) {
                List<Integer> last = lists.get(lists.size()-1);
                if (tmp.get(0) <= last.get(1)) {
                    int right = Math.max(tmp.get(1), last.get(1));
                    tmp.clear();
                    tmp.add(last.get(0));
                    tmp.add(right);
                    lists.remove(lists.size()-1);
                }
            }
            lists.add(tmp);
        }
        int[][] res = new int[lists.size()][2];
        int index = 0;
        for (List<Integer> list : lists) {
            res[index][0] = list.get(0);
            res[index++][1] = list.get(1);
        }
        return res;
    }

}
