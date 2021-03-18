package binsearch;

public class JZOffer53_1 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 二分查找找到target在数组中的起始下标
        while (left < right) {
            int mid = left + (right -left) / 2;
            // 因为要找起始下标，所以在相等时不跳过当前元素
            if (nums[mid] >= target) {
                right = mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        int res = 0;
        for (int i = left; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++res;
            }
        }
        return res;
    }

}
