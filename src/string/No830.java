package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No830 {

    public List<List<Integer>> largeGroupPositions(String s) {
        int n = s.length();
        List<List<Integer>> res = new ArrayList<>();
        if (n >= 3) {
            for (int i = 0; i < n; ++i) {
                int start = i;
                while (i + 1 < n && s.charAt(i+1) == s.charAt(i)) ++i;
                if (i - start + 1 >= 3) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(start, i));
                    res.add(list);
                }
            }
        }
        return res;
    }

}
