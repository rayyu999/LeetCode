package bitop;

public class JZOffer15 {

    public int hammingWeight(int n) {
        int cnt = 0;
        // 每次与1进行与运算看是否为1，运算后n右移一位继续下次运算
        while (n != 0) {
            cnt += n & 1;
            n >>>= 1;
        }
        return cnt;
    }

}
