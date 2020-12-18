package bitop;

public class No389 {

    /**
     * 位运算
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return (char) res;
    }

    /**
     * 求和法
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference_sum(String s, String t) {
        int s1 = 0, s2 = 0;
        for (char c : s.toCharArray()) {
            s1 += c;
        }
        for (char c : t.toCharArray()) {
            s2 += c;
        }
        return (char) (s2 - s1);
    }

}
