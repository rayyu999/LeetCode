package utils;

import java.util.Arrays;

/**
 * @ClassName Sort
 * @Author 36d
 * @Date 2021/6/13 13:07
 * @Description 排序工具类
 **/
public class Sort {

    /**
     * 快速排序
     * @param nums 排序数组
     */
    public static void quickSort(int[] nums) {
        partition(nums, 0, nums.length-1);
    }

    private static void partition(int[] nums, int low, int high) {
        if (low < high) {
            int k = nums[low], i = low, j = high;
            while (i < j) {
                while (i < j && nums[j] >= k) {
                    --j;
                }
                if (i < j) {
                    nums[i++] = nums[j];
                }
                while (i < j && nums[i] <= k) {
                    ++i;
                }
                if (i < j) {
                    nums[j--] = nums[i];
                }
            }
            nums[i] = k;
            partition(nums, low, i-1);
            partition(nums, i+1, high);
        }
    }

}
