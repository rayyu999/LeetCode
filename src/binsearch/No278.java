package binsearch;

import parents.VersionControl;

/**
 * @ClassName No278
 * @Author 36d
 * @Date 2021/6/13 11:38
 * @Description No278.第一个错误的版本
 **/
public class No278 extends VersionControl {

    public No278(int n, int wrongIndex) {
        super(n, wrongIndex);
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
