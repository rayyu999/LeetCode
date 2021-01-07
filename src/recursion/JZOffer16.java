package recursion;

public class JZOffer16 {

    /**
     * 递归
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 1) return x;
        if (n == 0 || x == 1) return 1;
        if (n == -1) return 1 / x;
        double half = myPow(x, n >> 1);
        double mod = myPow(x, n & 1);
        return half * half * mod;
    }

    /**
     * 非递归
     * @param x
     * @param n
     * @return
     */
    public double myPow_non_recur(double x, int n) {
        if (x == 0) return 0;
        double res = 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        while (n != 0) {
            if ((n & 1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }
        return res;
    }

}
