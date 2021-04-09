package arrays;

public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // 先计算所有元素的左侧乘积和
        for (int i = 1; i < n; ++i) {
            res[i] = nums[i - 1] * res[i - 1];
        }
        int r = 1;
        // 再计算所有元素的右侧乘积和
        for (int i = n - 1; i >= 0; --i) {
            res[i] *= r;
            r *= nums[i];
        }
        return res;
    }

}
