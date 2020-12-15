package greedy;

public class No738 {

    public int monotoneIncreasingDigits(int N) {
        if (N < 10) return N;
        char[] str = String.valueOf(N).toCharArray();
        for (int i = str.length - 2; i >= 0; --i) {
            if (str[i] > str[i + 1]) {
                --str[i];
                for (int j = i + 1; j < str.length; ++j) {
                    str[j] = '9';
                }
            }
        }
        return Integer.parseInt(String.valueOf(str));
    }

}
