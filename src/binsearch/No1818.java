package binsearch;

import java.util.Arrays;

/**
 * @Author Ray
 * @Date 2021/7/14 23:12
 * @Description 1818. 绝对差值和
 */
public class No1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        // sumDiff计算数组的原差值和，maxDiff记录使差值变化最大的替换差值
        int n = nums1.length, sumDiff = 0, maxDiff = 0;
        int[] nums3 = (int[])Arrays.copyOf(nums1, n);
        int MOD = 1000000007;
        Arrays.sort(nums3);
        for (int i = 0; i < n; ++i) {
            int curDiff = Math.abs(nums1[i] - nums2[i]);
            sumDiff = (sumDiff + curDiff) % MOD;
            // 寻找最接近的元素
            int j = binsearch(nums3, n, nums2[i]);
            // 更新最大替换差值
            int changeDiff = curDiff - Math.abs(nums3[j] - nums2[i]);
            maxDiff = Math.max(maxDiff, changeDiff);
        }
        return (sumDiff - maxDiff + MOD) % MOD;
    }

    private int binsearch(int[] nums3, int n, int target) {
        int l = 0, r = n - 1;
        while (l < r - 1) {
            int mid = l + (r - l >> 1);
            if (nums3[mid] == target) {
                return mid;
            } else if (nums3[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        // 循环到最后剩余两个元素，返回更接近的那个
        return Math.abs(nums3[l] - target) < Math.abs(nums3[r] - target) ? l : r;
    }

}
