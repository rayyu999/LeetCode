package arrays;

public class No34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums.length == 0) {
            res[0] = res[1] = -1;
        } else {
            res[0] = findFirst(nums, target);
            res[1] = res[0] == -1 ? -1 : findLast(nums, target);
        }
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索区间为 [mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索区间为 [left, mid]
                right = mid;
            } else {
                // 下一轮搜索区间为 [left, mid - 1]
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 下一轮搜索区间为 [left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索区间为 [mid, right]
                left = mid;
            } else {
                // 下一轮搜索区间为 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

}
