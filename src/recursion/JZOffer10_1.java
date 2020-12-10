package recursion;

public class JZOffer10_1 {

    public int fib(int n) {
        if (n < 2) return n;
        // 存储在数列中当前需要计算元素的前两个元素
        int fibNMinusOne = 1, fibNMinusTwo = 0;
        // 当前元素的计算结果
        int fibN = 0;
        for (int i = 2; i <=n; ++i) {
            fibN = (fibNMinusOne + fibNMinusTwo) % 1000000007;
            // 存储前两个元素，避免重复计算
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = fibN;
        }
        return fibN;
    }

}
