package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No217 {

    /**
     * 排序法
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; ++i) {
            if (nums[i] == nums[i+1]) return true;
        }
        return false;
    }

    /**
     * 哈希表法
     * @param nums
     * @return
     */
    public boolean containsDuplicate_hash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }

}
