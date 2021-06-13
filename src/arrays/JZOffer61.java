package arrays;

import utils.Sort;

/**
 * @ClassName JZOffer61
 * @Author 36d
 * @Date 2021/6/13 13:10
 * @Description 剑指 Offer 61. 扑克牌中的顺子
 **/
public class JZOffer61 {

    public static boolean isStraight(int[] nums) {
        Sort.quickSort(nums);
        int joker = 0;
        // 统计大小王的个数
        for (int num : nums) {
            if (num != 0) {
                break;
            }
            ++joker;
        }
        int pre = 0;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            // 设置顺子起始
            if (pre == 0) {
                pre = num;
                continue;
            }
            if (num == pre) {
                // 出现相同的牌，不可能是顺子
                return false;
            } else if (num != pre + 1) {
                // 若当前牌不是上一张牌+1，判断大小王的个数能否抵消中间缺的牌
                int diff = num - pre - 1;
                joker -= diff;
                if (joker < 0) {
                    return false;
                }
            }
            // 记录上一张牌的点数
            pre = num;
        }
        return true;
    }

}
