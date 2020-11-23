package string;

import java.util.ArrayList;

public class No6 {

    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        ArrayList<StringBuilder> str = new ArrayList<>();
        int cur = 0, curRow = 0, step = -1, n = s.length();
        for (int i = 0; i < numRows; i++) {
            str.add(new StringBuilder());
        }
        while (cur < n) {
            if (curRow == 0 || curRow == numRows - 1) {
                step *= -1;
            }
            str.get(curRow).append(s.charAt(cur++));
            curRow += step;
        }
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            ans += str.get(i);
        }
        return ans;
    }

}
