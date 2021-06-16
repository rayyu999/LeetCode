package binsearch;

/**
 * @Author Ray
 * @Date 2021/6/16 22:11
 * @Description 852.山脉数组的峰顶索引
 */
public class No852 {

    /**
     * 二分查找
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int low = 1, high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid+1]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * 找最大值
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray_findMax(int[] arr) {
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }

}
