package dp;

/**
 * @Author Ray
 * @Date 2021/6/28 22:21
 * @Description 152.乘积最大子数组
 */
public class No152 {

    public int maxProduct(int[] nums) {
        int preMin = 1, preMax = 1, max = Integer.MIN_VALUE;
        for (int num : nums) {
            // 若当前数为负数，则相乘后最小数会变成最大数，最大数会变成最小数
            // 因此在这里进行调换
            if (num < 0) {
                int tmp = preMax;
                preMax = preMin;
                preMin = tmp;
            }
            // 更新当前最大值：与前面结果的乘积和当前元素中的较大值
            preMax = Math.max(preMax*num, num);
            // 更新当前最小值：与前面结果的乘积和当前元素中的较小值
            preMin = Math.min(preMin*num, num);
            max = Math.max(max, preMax);
        }
        return max;
    }

}
