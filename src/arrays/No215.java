package arrays;

import java.util.Random;

public class No215 {

    private Random random = new Random();
    /**
     * 快速排序版
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_quickSort(int[] nums, int k) {
        return quickSort(nums, nums.length-k, 0, nums.length-1);
    }

    private int quickSort(int[] nums, int k, int low, int high) {
        // 快排过程
        if (low < high) {
            randomSwap(nums, low, high);
            int i = low, j = high, p = nums[low];
            while (i < j) {
                while (i < j && nums[j] >= p) {
                    --j;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    ++i;
                }
                while (i < j && nums[i] <= p) {
                    ++i;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    --j;
                }
            }
            nums[i] = p;
            // 判断当前有序的元素是否满足题目要求
            if (i == k) {
                return nums[i];
            } else if (i > k) {
                return quickSort(nums, k, 0, i - 1);
            } else {
                return quickSort(nums, k, i + 1, high);
            }
        }
        return nums[low];
    }

    private void randomSwap(int[] nums, int low, int high) {
        // 引入随机化来优化时间复杂度
        int i = random.nextInt(high - low + 1) + low;
        int tmp = nums[i];
        nums[i] = nums[low];
        nums[low] = tmp;
    }

    /**
     * 堆排序版
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_heapSort(int[] nums, int k) {
        buildHeap(nums);
        int n = nums.length;
        for (int i = 0; i < k - 1; ++i) {
            // 将最大的元素取出
            swap(nums, 0, n - i - 1);
            // 调整结构，保持大顶堆的结构
            heapAdjust(nums, 0, n - i - 1);
        }
        return nums[0];
    }

    private void buildHeap(int[] nums) {
        int n = nums.length;
        // 构造大顶堆
        for (int i = n / 2; i >= 0; i--) {
            heapAdjust(nums, i, n);
        }
    }

    private void heapAdjust(int[] nums, int root, int n) {
        int father, child;
        for (father = nums[root]; leftChild(root) < n; root = child) {
            child = leftChild(root);
            // 取左右节点中较大的那个与父节点比较
            if (child < n - 1 && nums[child] < nums[child+1]) {
                ++child;
            }
            // 若父节点比子节点小，则需要交换
            if (father < nums[child]) {
                nums[root] = nums[child];
            } else {
                // 若本次比较不需要判断，则当前的父节点已到达该到的位置
                break;
            }
        }
        nums[root] = father;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
