package dbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Ray
 * @Date 2021/5/28 22:13
 * @Description 78.子集
 */
public class No78 {

    Set<Integer> visited;
    List<List<Integer>> res;

    /**
     * 回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets_dfs(int[] nums) {
        visited = new HashSet<>();
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        // 遍历起点
        for (int i = 0; i < nums.length; ++i) {
            bfs(nums, i, list);
        }
        return res;
    }

    private void bfs(int[] nums, int index, List<Integer> list) {
        if (index >= nums.length || !visited.contains(nums[index])) {
            int num = nums[index];
            // 将当前元素添加到路径中
            list.add(num);
            res.add(new ArrayList<>(list));
            visited.add(num);
            for (int i = index + 1; i < nums.length; ++i) {
                bfs(nums, i, list);
            }
            // 回溯
            list.remove(list.size()-1);
            visited.remove(num);
        }
    }

    /**
     * 两层循环
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int num : nums) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(num);
            int size = res.size();
            for (int i = 0; i < size; ++i) {
                List<Integer> list = res.get(i);
                List<Integer> newList = new ArrayList<>(list);
                list.add(num);
                res.add(newList);
            }
            res.add(tmp);
        }
        res.add(new ArrayList<>());
        return res;
    }

}
