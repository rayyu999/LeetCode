package arrays;

public class No4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        // 合并数组长度为奇数和偶数的情况
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;

        return (findKthSmall(left, nums1, nums2, 0, n-1, 0, m-1) + findKthSmall(right, nums1, nums2, 0, n-1, 0, m-1)) * 0.5;
    }

    public int findKthSmall(int k, int[] nums1, int[] nums2, int s1, int e1, int s2, int e2) {
        int len1 = e1 - s1 + 1, len2 = e2 - s2 + 1;

        // 始终令数组1的长度小于数组2
        if (len1 > len2) return findKthSmall(k, nums2, nums1, s2, e2, s1, e1);

        // 第一个数组已被全部排除，则直接输出数组2中的第k个元素
        if (len1 == 0) return nums2[s2 + k - 1];
        // 若k为1，则对比两个数组的首元素，输出较小的元素
        if (k == 1) return Math.min(nums1[s1], nums2[s2]);

        // 比较两个数组的第k/2个元素（每次剔除k/2个元素），注意不要越界
        int m1 = s1 + Math.min(k/2, len1) - 1;
        int m2 = s2 + Math.min(k/2, len2) - 1;
        if (nums1[m1] > nums2[m2]) {
            // 这种情况下数组2中的前k/2个元素都不可能为第k大的数，将其剔除
            return findKthSmall(k-Math.min(k/2, len2), nums1, nums2, s1, e1, m2+1, e2);
        } else {
            // 反之数组1中的前k/2个元素都不可能为第k大的数，将其剔除
            return findKthSmall(k-Math.min(k/2, len1), nums1, nums2, m1+1, e1, s2, e2);
        }
    }

}
