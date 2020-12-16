package greedy;

public class JZOffer14_2 {

    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        long res = 1L;
        // 尽可能多的剪去长度为3的绳子
        // 当绳子最后剩下的长度为4的时候，不能再剪3
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) res * n % 1000000007;
    }

}
