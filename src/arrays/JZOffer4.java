package arrays;

public class JZOffer4 {

    /**
     * 线性查找法
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        // 从右上角开始搜索
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) return true;
                // 当前元素小于target，往下搜索
            else if (matrix[r][c] < target) ++r;
                // 当前元素大于target，往左搜索
            else --c;
        }
        return false;
    }

    /**
     * 二分查找法
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray_binarySearch(int[][] matrix, int target) {
        for (int[] arr : matrix) {
            if (findNum(arr, target)) return true;
        }
        return false;
    }

    public boolean findNum(int[] arr, int target) {
        int left = 0, right = arr.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

}
