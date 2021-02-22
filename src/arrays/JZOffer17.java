package arrays;

public class JZOffer17 {

    public int[] printNumbers(int n) {
        int len = 1;
        for (int i = 0; i < n; ++i) {
            len *= 10;
        }
        int[] res = new int[len - 1];
        for (int i = 1; i < len; ++i) {
            res[i-1] = i;
        }
        return res;
    }

}
