package dp;

/**
 * @Author Ray
 * @Date 2021/6/24 22:58
 * @Description 673.最长递增子序列的个数
 */
public class No673 {

    public int findNumberOfLIS(int[] nums) {
        // cnt为结果，maxLen为当前访问过的元素的最长子序列长度
        int n = nums.length, cnt = 0, maxLen = 1;
        // dp数组统计子序列个数，len数组统计子序列的最长长度
        int[] count = new int[n];
        int[] len = new int[n];
        for (int i = 0; i < n; ++i) {
            // 初始状态
            len[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (len[j] + 1 > len[i]) {
                        // 最长子序列长度发生变化，当前元素的最长子序列个数也要发生变化
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if (len[j] + 1 == len[i]) {
                        // j的最长子序列长度+1与i的长度相等，i的最长子序列个数加上j的个数
                        count[i] += count[j];
                    }
                }
            }
            // 根据当前最长子序列进行更新，类似循环内的逻辑
            if (len[i] == maxLen) {
                cnt += count[i];
            } else if (len[i] > maxLen) {
                maxLen = len[i];
                cnt = count[i];
            }
        }
        return cnt;
    }

}
