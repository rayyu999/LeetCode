package greedy;

public class No135 {

    public int candy(int[] ratings) {
        int n = ratings.length, res = 0, right;
        int[] left = new int[n];
        left[0] = 1;
        // 先判断左规则
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i-1]) left[i] = left[i-1] + 1;
            else left[i] = 1;
        }
        right = left[n-1];
        res += right;
        // 再判断右规则
        for (int i = n-2; i >= 0; --i) {
            // 当当前分数比右边高时，当前糖果数为右边糖果数+1与满足左规则最低糖果数中的较大值
            if (ratings[i] > ratings[i+1]) right = Math.max(left[i], right+1);
                // 当当前分数比右边高时，当前糖果数为1与满足左规则最低糖果数中的较大值
            else right = Math.max(left[i], 1);
            res += right;
        }
        return res;
    }

}
