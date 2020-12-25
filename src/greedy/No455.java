package greedy;

import java.util.Arrays;

public class No455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0, j = 0;
        for (int i = 0; i < g.length; ++i) {
            while (j < s.length && s[j] < g[i]) ++j;
            if (j >= s.length) break;
            else ++cnt;
            ++j;
        }
        return cnt;
    }

}
