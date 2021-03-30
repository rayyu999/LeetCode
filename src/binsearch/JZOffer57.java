package binsearch;

public class JZOffer57 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            int sub = target - nums[i];
            int index = binsearch(nums, i+1, nums.length, sub);
            if (index != -1) {
                res[0] = nums[i];
                res[1] = nums[index];
                break;
            }
        }
        return res;
    }

    private int binsearch(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int left = low, right = high - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return -1;
    }

}
