package dfs;

import java.util.ArrayList;
import java.util.List;

public class No46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            // 遍历所有起点
            dfs(nums, i, list, isVisited, res);
        }
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, boolean[] isVisited, List<List<Integer>> res) {
        list.add(nums[index]);
        isVisited[index] = true;
        // 检查是否已经把所有元素都加入到列表
        if (list.size() == nums.length) {
            // 是则把当前排列添加到答案
            res.add(new ArrayList<Integer>(list));
        } else {
            // 否则继续对未加入的元素进行dfs
            for (int i = 0; i < nums.length; ++i) {
                if (!isVisited[i])
                    dfs(nums, i, list, isVisited, res);
            }
        }
        isVisited[index] = false;
        list.remove(list.size()-1);
        return;
    }

}
