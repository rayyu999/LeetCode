package binsearch;

public class No153 {

    public int findMin(int[] nums) {
        return partition(nums, 0, nums.length - 1);
    }

    private int partition(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        if (low > high) {
            return Integer.MAX_VALUE;
        }
        int mid = (low + high) / 2;
        int min = nums[mid];
        if (nums[low] < nums[mid]) {
            // 左边有序的情况
            // 左边最小的数为左边子数组的第一个元素
            int left = nums[low];
            min = Math.min(min, left);
            // 右边子数组继续搜索
            int right = partition(nums, mid + 1, high);
            min = Math.min(min, right);
        } else {
            // 右边有序的情况
            // 右边最小的数为右边子数组的第一个元素
            int right = nums[mid + 1];
            min = Math.min(min, right);
            int left = partition(nums, low, mid - 1);
            min = Math.min(min, left);
        }
        return min;
    }

}
