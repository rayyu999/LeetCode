package arrays;

public class JZOffer3 {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i) {
                int m = nums[i];
                if (nums[m] == nums[i]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
            }
        }
        return -1;
    }

}
