package math;

public class No204 {

    public int countPrimes(int n) {
        // 用时为0ms的代码：
        // if (n == 10000)
        //     return 1229;
        // if (n == 499979)
        //     return 41537;
        // if (n == 999983)
        //     return 78497;
        // if (n == 1500000)
        //     return 114155;

        byte[] sign = new byte[n];
        int cnt = 0;
        for (int i = 2; i < n; ++i) {
            if (sign[i] == 1) continue;
            ++cnt;
            for (int j = 2; j * i < n; ++j) sign[j * i] = 1;
        }
        return cnt;
    }

}
