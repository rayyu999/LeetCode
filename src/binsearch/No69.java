package binsearch;

public class No69 {

    public int mySqrt(int x) {
        int low = 1, high = x;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // 防止溢出，这里使用除法
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                // 如果low发生了变化，循环过后会指向结果的下一个元素
                low = mid + 1;
            }
        }
        // 处理low一直没变的情况
        if (low <= x / low) {
            return low;
        }
        return low - 1;
    }

}
