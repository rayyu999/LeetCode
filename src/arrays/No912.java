package arrays;

import java.util.Random;

public class No912 {

    public int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }

    private void partition(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        // 随机选择基准值
        randomLow(nums, low, high);
        int p = nums[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] >= p) {
                --j;
            }
            if (i < j) {
                nums[i] = nums[j];
                ++i;
            }
            while (i < j && nums[i] <= p) {
                ++i;
            }
            if (i < j) {
                nums[j] = nums[i];
                --j;
            }
        }
        nums[i] = p;
        partition(nums, low, i - 1);
        partition(nums, i + 1, high);
    }

    private void randomLow(int[] nums, int low, int high) {
        Random random = new Random();
        int pos = random.nextInt(high - low + 1);
        swap(nums, low, low + pos);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
