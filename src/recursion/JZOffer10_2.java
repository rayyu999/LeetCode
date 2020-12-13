package recursion;

public class JZOffer10_2 {

    public int numWays(int n) {
        if (n <= 1) return 1;
        int sum = 0, p = 1, q = 1;
        for (int i = 2; i <= n; ++i) {
            sum = (p + q) % 1000000007;
            q = p;
            p = sum;
        }
        return sum;
    }

}
