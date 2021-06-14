package binsearch;

import parents.GuessGame;

/**
 * @Author Ray
 * @Date 2021/6/14 19:39
 * @Description 374.猜数字大小
 */
public class No374 extends GuessGame {

    public No374(int pick) {
        super(pick);
    }

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
