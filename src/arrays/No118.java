package arrays;

import java.util.ArrayList;
import java.util.List;

public class No118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = null;   // 记录上一行的结果
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    // 两边的元素都为1
                    row.add(1);
                } else {
                    // 中间元素等于上一行的对应下标元素与其前一个元素相加
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            res.add(row);
            pre = row;
        }
        return res;
    }

}
