package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < len; ++first) {
            // 若当前元素与上一个元素相同，去重，跳过本次循环
            if (first > 0 && nums[first] == nums[first-1]) continue;
            int third = len - 1;
            for (int second = first + 1; second < len; ++second) {
                // 若当前元素与上一个元素相同，去重，跳过本次循环
                if (second > first + 1 && nums[second] == nums[second-1]) continue;
                // 固定前两个指针，移动第三个指针
                while (third > second && nums[first] + nums[second] + nums[third] > 0) --third;
                if (third == second) break;
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }

}
