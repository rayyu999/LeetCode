package arrays;

/**
 * @Author Ray
 * @Date 2021/5/28 22:11
 * @Description 75.颜色分类
 */
public class No75 {

    /**
     * 统计颜色法
     * @param nums
     */
    public void sortColors_count(int[] nums) {
        int red = 0, blue = 0, white = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    ++red;
                    break;
                case 1:
                    ++blue;
                    break;
                case 2:
                    ++white;
                    break;
            }
        }
        int index = 0;
        while (red-- > 0) {
            nums[index++] = 0;
        }
        while (blue-- > 0) {
            nums[index++] = 1;
        }
        while (white-- > 0) {
            nums[index++] = 2;
        }
    }

    /**
     * 三指针法
     * @param nums
     */
    public void sortColors_3pointers(int[] nums) {
        int left = -1, right = nums.length;
        // 寻找放0以及放2的位置
        while (left+1 < nums.length && nums[++left] == 0) {}
        while (right-1 >= 0 && nums[--right] == 2) {}
        // 数组本身满足要求，直接返回
        if (left == nums.length-1 || right == 0) {
            return;
        }
        // 遍历数组，将访问到的0和2与上面寻找到的两个指针交换位置
        for (int i = left; i <= right; ++i) {
            switch (nums[i]) {
                case 0:
                    // 这里不需要再次判断的原因是：
                    // 前面的元素都是遍历过的，能保证交换过来的元素不是2
                    swap(nums, i, left++);
                    break;
                case 2:
                    // i--的意思是交换之后要再次判断当前位置的元素是否需要移动，
                    // 若交换过来的是0的话就要再移动一次
                    swap(nums, i--, right--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
