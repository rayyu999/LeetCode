package arrays;

import java.util.HashMap;
import java.util.Map;

public class No1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                return new int[] {map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
