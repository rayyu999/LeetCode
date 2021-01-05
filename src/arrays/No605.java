package arrays;

public class No605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0, zero = 1;  // zero记录连续零的个数，这里假设在数组左边添一个0
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 0) {
                ++zero;
            } else {
                zero = 0;
            }
            if (zero == 3) {
                // 每连续三个零，在中间种一朵花
                ++cnt;
                zero = 1;
            }
        }
        // 若最后零个数为2，证明最后一个位置可以种花
        if (zero == 2) ++cnt;
        return cnt >= n ? true : false;
    }

}
